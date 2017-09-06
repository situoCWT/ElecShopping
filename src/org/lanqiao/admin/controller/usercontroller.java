package org.lanqiao.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Order;
import org.lanqiao.entity.User;
import org.lanqiao.service.OrderDetailService;
import org.lanqiao.service.OrderDetailServiceImpl;
import org.lanqiao.service.OrderService;
import org.lanqiao.service.OrderServiceImpl;
import org.lanqiao.service.PasswordAnswerService;
import org.lanqiao.service.PasswordAnswerServiceImpl;
import org.lanqiao.service.UserService;
import org.lanqiao.service.UserServiceImpl;

import com.google.gson.Gson;


@WebServlet("/usercontroller.do")
public class usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type!=null && type.equals("select"))
		{
			UserService us = new UserServiceImpl();
			List<User> list = us.getList();
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(list));
		}
		else if(type!=null && type.equals("del"))
		{
			String userid = request.getParameter("userid");
			
			OrderDetailService ods = new OrderDetailServiceImpl();
			
			OrderService os = new OrderServiceImpl();
			
			PasswordAnswerService pas = new PasswordAnswerServiceImpl();
			
			UserService us = new UserServiceImpl();
			
			List<Order> orderlist = os.getOrderList(userid);
			
			if(orderlist!=null)
			for(int i=0;i<orderlist.size();i++)
			{
				ods.deleteOrderDetailByOrderid(orderlist.get(i).getOrderid());
			}
			os.deleteOrderByUserid(userid);
			pas.deletePasswordAnswerByUserid(userid);
			us.deleteUser(userid);
			response.getWriter().write("1");
		}
		else if(type!=null && type.equals("add"))
		{
			String uemail = request.getParameter("uemail");
			String uname = request.getParameter("uname");
			String upassword = request.getParameter("upassword");
			String usex = request.getParameter("usex");
			String utel = request.getParameter("utel");
			String uaddr = request.getParameter("uaddr");
			String uid = UUID.randomUUID().toString();
			String ustateid = "1";
			String uroleid = "2";
			User user = new User(uid, uemail, uname, upassword, usex, uaddr, utel, ustateid, uroleid);
			UserService us = new UserServiceImpl();
			us.insertUser(user);
			response.getWriter().write("1");
		}
		else if(type!=null && type.equals("edit"))
		{
			String uemail = request.getParameter("edituemail");
			String uname = request.getParameter("edituname");
			String upassword = request.getParameter("editupassword");
			String usex = request.getParameter("editusex");
			String utel = request.getParameter("editutel");
			String uaddr = request.getParameter("edituaddr");
			UserService us = new UserServiceImpl();
			User user = us.getUser(uname);
			user.setUemail(uemail);
			user.setUloginid(uname);
			user.setUpassword(upassword);
			user.setUsex(usex);
			user.setUtel(utel);
			user.setUaddress(uaddr);
			us.updateUser(user);
			response.getWriter().write("1");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
