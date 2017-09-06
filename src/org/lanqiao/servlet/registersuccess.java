package org.lanqiao.servlet;

import java.io.IOException;
import java.util.UUID;

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
import org.lanqiao.util.MailUtil;

@WebServlet("/registersuccess.do")
public class registersuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		String code = request.getSession().getAttribute("code").toString();
		String checknum = request.getParameter("checknum");
		if(!code.equalsIgnoreCase(checknum))
		{
			request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
			return ;
		}
		String uemail = request.getParameter("uemail");
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		String usex = request.getParameter("usex");
		String utel = request.getParameter("utel");
		String uaddr = request.getParameter("uaddr");
		String uid = UUID.randomUUID().toString();
		String ustateid = "2";
		String uroleid = "2";
		User user = new User(uid, uemail, uname, upassword, usex, uaddr, utel, ustateid, uroleid);
		UserService us = new UserServiceImpl();
		us.insertUser(user);
		
		String squestions = request.getParameter("squestions");
		String uanswer = request.getParameter("uanswer");
		String ubackupemail = request.getParameter("ubackupemail");
		String answerid = UUID.randomUUID().toString();
		PasswordAnswer passwordanswer = new PasswordAnswer(answerid, squestions, uanswer, ubackupemail, uid);
		PasswordAnswerService pas = new PasswordAnswerServiceImpl();
		pas.insertPasswordAnswer(passwordanswer);
		
		MailUtil mu = new MailUtil();
		mu.sendMail("347095722@qq.com", "请激活你的账号", "localhost:8080/web-project/enable.do?uloginid="+uname);
		request.getRequestDispatcher("/WEB-INF/registersuccess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
