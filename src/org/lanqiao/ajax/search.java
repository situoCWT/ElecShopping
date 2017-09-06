package org.lanqiao.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Search;
import org.lanqiao.service.SearchService;
import org.lanqiao.service.SearchServiceImpl;

import com.google.gson.Gson;

@WebServlet("/search.do")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("search");
		SearchService ss = new SearchServiceImpl();
		List<Search> list = ss.getlist();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
