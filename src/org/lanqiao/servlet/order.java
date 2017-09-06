package org.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Cart;
import org.lanqiao.entity.User;
import org.lanqiao.service.CartService;
import org.lanqiao.service.CartServiceImpl;
import org.lanqiao.service.UserService;
import org.lanqiao.service.UserServiceImpl;


@WebServlet("/order.do")
public class order extends HttpServlet {
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
			String uloginid = request.getSession().getAttribute("uloginid").toString();
			UserService us = new UserServiceImpl();
			User user = us.getUser(uloginid);
			CartService cs = new CartServiceImpl();
			List<Cart> cartlist = cs.getCartList();
			request.setAttribute("cartlist", cartlist);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
