package org.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie cookie =null;
		for(Cookie c:cookies)
		{
			 if(c.getName().equals("cookieloginid"))
			 {
				 cookie = c;
				 break;
			 }
		}
		if(request.getSession().getAttribute("uloginid")!=null || cookie!=null)
		{
			if(request.getSession().getAttribute("uloginid")==null)
			{
				request.getSession().setAttribute("uloginid",cookie.getValue());
			}
			request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
