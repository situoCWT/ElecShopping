package org.lanqiao.servlet;

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

@WebServlet("/list.do")
public class listService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String pageindex = request.getParameter("pageindex");
		if(cid==null)
		{
			cid="1";
		}
		if(pageindex==null)
		{
			pageindex="1";
		}
			String pagesize="5";
			PageInfoService ps = new PageInfoServiceImpl();
			PageInfo<Goods> pageinfo = ps.goodslist(cid,Integer.parseInt(pagesize),Integer.parseInt(pageindex));
			CategoryService cs = new CategoryServiceImpl();
			Category cate = cs.getCategory(cid);
			request.setAttribute("cate", cate);
			request.setAttribute("pageinfo",pageinfo);
			request.setAttribute("cid", cid);
			request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
