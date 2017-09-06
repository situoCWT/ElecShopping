package org.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
import org.lanqiao.service.UserServiceImpl;

@WebServlet("/logincheck.do")
public class logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginname = request.getParameter("uloginid");
		String loginpassword = request.getParameter("upassword");
		UserService us = new UserServiceImpl();
		User user = us.getUser(loginname);
		boolean checkresult = us.checkLogin(loginname, loginpassword);
		if(checkresult && user.getUstateid().equals("1"))
		{
			request.getSession().setMaxInactiveInterval(10);
			String chk = request.getParameter("chk");
			if(chk!=null)
			{
				
				Cookie cookie = new Cookie("cookieloginid",loginname);
				cookie.setMaxAge(60*60*24);
				response.addCookie(cookie);
				request.getSession().setAttribute("uloginid", user.getUloginid());
				request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);	
			}
			else
			{
				request.getSession().setAttribute("uloginid", user.getUloginid());
				request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);	
			}
			
		}
		else
		{
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
