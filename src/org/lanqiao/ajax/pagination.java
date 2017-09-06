package org.lanqiao.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.CategoryService;
import org.lanqiao.service.CategoryServiceImpl;
import org.lanqiao.service.PageInfoService;
import org.lanqiao.service.PageInfoServiceImpl;

import com.google.gson.Gson;

@WebServlet("/pagination.do")
public class pagination extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String pageindex = request.getParameter("pageIndex");
		String pagesize = request.getParameter("pageSize");
		if(cid==null)
		{
			cid="1";
		}
		if(pageindex==null || pageindex.equals("0"))
		{
			pageindex="0";
		}
		if(pagesize==null)
		{
			pageindex="5";
		}

			PageInfoService ps = new PageInfoServiceImpl();
			PageInfo<Goods> pageinfo = ps.goodslist(cid,Integer.parseInt(pagesize),Integer.parseInt(pageindex)+1);
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(pageinfo));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
