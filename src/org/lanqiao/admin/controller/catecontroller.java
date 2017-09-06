package org.lanqiao.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Category;
import org.lanqiao.service.CategoryService;
import org.lanqiao.service.CategoryServiceImpl;

import com.google.gson.Gson;

@WebServlet("/catecontroller.do")
public class catecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type!=null&&type.equals("search"))
		{
			CategoryService cs = new CategoryServiceImpl();
			List<Category> list = cs.list();
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(list));
		}
		else if(type!=null&&type.equals("del")){
			String cid = request.getParameter("cid");
			CategoryService cs = new CategoryServiceImpl();
			cs.deleteCategoryByCid(cid);
			response.getWriter().write("1");
		}
		else if(type!=null&&type.equals("add")){
			String cid = request.getParameter("cid");
			String cname = request.getParameter("cname");
			Category chkcategory = null;
			CategoryService cs = new CategoryServiceImpl();
			chkcategory = cs.getCategory(cid);
			if(chkcategory == null)
			{
				Category category = new Category();
				category.setCid(cid);
				category.setCname(cname);
				cs.insertCategory(category);
				response.getWriter().write("1");
			}
			if(chkcategory != null)
			{
				response.getWriter().write("0");
			}
		}
		else if(type!=null&&type.equals("edit")){
			String cid = request.getParameter("editcid");
			String cname = request.getParameter("editcname");
			CategoryService cs = new CategoryServiceImpl();
			cs.updateCategory(cid, cname);
			response.getWriter().write("1");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
