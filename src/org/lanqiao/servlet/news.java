package org.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.Dao.NewsDao;
import org.lanqiao.Dao.NewsDaoImpl;
import org.lanqiao.entity.News;

@WebServlet("/news.do")
public class news extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		NewsDao dao = new NewsDaoImpl();
		List<News> list = dao.newslist();
		request.setAttribute("newslist",list);
		request.setAttribute("id",id);
		request.getRequestDispatcher("/WEB-INF/news.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
