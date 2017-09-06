package org.lanqiao.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service.UserService;
import org.lanqiao.service.UserServiceImpl;

@WebServlet("/userlogin.do")
public class userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uloginid = request.getParameter("uloginid");
		String upassword = request.getParameter("upassword");
		UserService us = new UserServiceImpl();
		boolean sign = us.checkLogin(uloginid, upassword);
		if(sign==true){
			response.getWriter().write("1");
		}
		else{
			response.getWriter().write("0");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
