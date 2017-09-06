package org.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.User;
import org.lanqiao.service.PasswordAnswerService;
import org.lanqiao.service.PasswordAnswerServiceImpl;
import org.lanqiao.service.UserService;
import org.lanqiao.service.UserServiceImpl;


@WebServlet("/success.do")
public class success extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upassword = request.getParameter("upassword");
		String usex = request.getParameter("usex");
		String utel= request.getParameter("utel");
		String uaddress = request.getParameter("uaddress");
		String uloginid = request.getParameter("uloginid");
		UserService us = new UserServiceImpl();
		User user = us.getUser(uloginid);
		user.setUpassword(upassword);
		user.setUsex(usex);
		user.setUtel(utel);
		user.setUaddress(uaddress);
		us.updateUser(user);
		
		
		
		
		String squestions = request.getParameter("squestions");
		String uanswer = request.getParameter("uanswer");
		String ubackupemail = request.getParameter("ubackupemail");
		PasswordAnswerService pas  = new PasswordAnswerServiceImpl();
		PasswordAnswer passwordanswer = pas.getPasswordAnswer(user.getUserid());
		passwordanswer.setAquestion(squestions);
		passwordanswer.setAnswer(uanswer);
		passwordanswer.setEmail(ubackupemail);
		pas.updatePasswordAnswer(passwordanswer);
		
		
		request.getSession().setAttribute("ulogin", user.getUloginid());
		request.getSession().setAttribute("upassword", upassword);
		request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
