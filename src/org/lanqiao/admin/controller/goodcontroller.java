package org.lanqiao.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.GoodsService;
import org.lanqiao.service.GoodsServiceImpl;
import org.lanqiao.service.PageInfoService;
import org.lanqiao.service.PageInfoServiceImpl;

import com.google.gson.Gson;

@WebServlet("/goodcontroller.do")
public class goodcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type!=null&&type.equals("search")){
			String cid = request.getParameter("cid");
			String pagesize = request.getParameter("rows");
			String pageindex = request.getParameter("page");
			PageInfoService ps = new PageInfoServiceImpl();
			PageInfo<Goods> pageinfo = ps.goodslist(cid, Integer.parseInt(pagesize),Integer.parseInt(pageindex));
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("total", pageinfo.getTotalnumber());
			map.put("rows", pageinfo.getList());
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(map));
		}else if(type!=null&&type.equals("del")){
			String gid = request.getParameter("gid");
			System.out.println(gid);
			GoodsService gs = new GoodsServiceImpl();
			gs.delectgoodsbygid(gid);
			response.getWriter().write("1");
		}else if(type!=null&&type.equals("add")){
			System.out.println("123");
			String gid = request.getParameter("addgid");
			String gtitle = request.getParameter("addgtitle");
			String gauthor = request.getParameter("addgauthor");
			String gsaleprice = request.getParameter("addgsaleprice");
			String ginprice = request.getParameter("addginprice");
			String gdesc = request.getParameter("addgdesc");
			String gimg = request.getParameter("addgimg");
			String gclick = request.getParameter("addgclick");
			String cid = request.getParameter("addcid");
			String pid = request.getParameter("addpid");
			System.out.println(gdesc);
			Goods good = new Goods();
			good.setGid(gid);
			good.setGtitle(gtitle);
			good.setGauthor(gauthor);
			good.setGsaleprice(Double.parseDouble(gsaleprice));
			good.setGinprice(Double.parseDouble(ginprice));
			good.setGdesc(gdesc);
			good.setGimg(gimg);
			good.setGclick(Integer.parseInt(gclick));
			good.setCid(cid);
			good.setPid(pid);
			
			GoodsService gs = new GoodsServiceImpl();
			Goods chkgood = gs.getgoods(gid);
			if(chkgood!=null)
			{
				response.getWriter().write("0");
			}
			if(chkgood==null)
			{
				gs.insertgood(good);
				response.getWriter().write("1");
			}
		}
		else if(type!=null&&type.equals("edit")){
			String gid = request.getParameter("editgid");
			String gtitle = request.getParameter("editgtitle");
			String gauthor = request.getParameter("editgauthor");
			String gsaleprice = request.getParameter("editgsaleprice");
			String ginprice = request.getParameter("editginprice");
			String gdesc = request.getParameter("editgdesc");
			String gimg = request.getParameter("editgimg");
			String gclick = request.getParameter("editgclick");
			String cid = request.getParameter("editcid");
			String pid = request.getParameter("editpid");

			Goods good = new Goods();
			good.setGid(gid);
			good.setGtitle(gtitle);
			good.setGauthor(gauthor);
			good.setGsaleprice(Double.parseDouble(gsaleprice));
			good.setGinprice(Double.parseDouble(ginprice));
			good.setGdesc(gdesc);
			good.setGimg(gimg);
			good.setGclick(Integer.parseInt(gclick));
			good.setCid(cid);
			good.setPid(pid);
			
			GoodsService gs = new GoodsServiceImpl();
			gs.updategood(good);

			response.getWriter().write("1");
		}
		else if(type!=null&&type.equals("likesearch")){
			String cid = request.getParameter("cid");
			String value = request.getParameter("value");
			String pagesize = request.getParameter("rows");
			String pageindex = request.getParameter("page");
			if(value!=null)
			{
				PageInfoService ps = new PageInfoServiceImpl();
				PageInfo<Goods> pageinfo = ps.getgoodslistbylike(value,cid, Integer.parseInt(pagesize),Integer.parseInt(pageindex));
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("total", pageinfo.getTotalnumber());
				map.put("rows", pageinfo.getList());
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(map));
			}
		}
		else if(type!=null&&type.equals("smartsearch")){
			String cid = request.getParameter("cid");
			String value = request.getParameter("value");
			if(value==null)
			{
				System.out.println("123");
			}
			if(value!=null)
			{
				System.out.println("456");
				GoodsService gs = new GoodsServiceImpl();
				List<Goods> list = gs.getgoodslistbylike(value, cid);
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(list));
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
