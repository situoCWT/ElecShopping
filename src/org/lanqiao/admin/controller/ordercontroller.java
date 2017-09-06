package org.lanqiao.admin.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Order;

import org.lanqiao.service.OrderService;
import org.lanqiao.service.OrderServiceImpl;

import com.google.gson.Gson;


@WebServlet("/ordercontroller.do")
public class ordercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type!=null&&type.equals("search"))
		{
			OrderService os = new OrderServiceImpl();
			List<Order> list = os.getOrderList();
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(list));
		}
		else if(type!=null&&type.equals("del")){
			String orderid = request.getParameter("orderid");
			OrderService os = new OrderServiceImpl();
			os.deleteOrderByOrderid(orderid);
			response.getWriter().write("1");
		}
		else if(type!=null&&type.equals("add")){
			String orderid =UUID.randomUUID().toString();
			String userid = request.getParameter("adduserid");
			String gid = request.getParameter("addgid");
			Double totalprice = Double.parseDouble(request.getParameter("addtotalprice"));
			String orderdate = request.getParameter("addorderdate");
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date =null;
			try {
				date = dateFormat.parse(orderdate);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String state = request.getParameter("addstate");
			Order chkorder = null;
			OrderService os = new OrderServiceImpl();
			chkorder = os.getOrderByOrderid(orderid);
			if(chkorder == null)
			{
				Order order = new Order();
				order.setOrderid(orderid);
				order.setUserid(userid);
				order.setGid(gid);
				order.setTotalprice(totalprice);
				order.setOrderdate(date);
				order.setState(state);
				os.insertOrderListByGetDate(order);
				response.getWriter().write("1");
			}
			if(chkorder != null)
			{
				response.getWriter().write("0");
			}
		}
		else if(type!=null&&type.equals("edit")){
			String orderid =request.getParameter("editorderid");
			String userid = request.getParameter("edituserid");
			String gid = request.getParameter("editgid");
			Double totalprice = Double.parseDouble(request.getParameter("edittotalprice"));
			String orderdate = request.getParameter("editorderdate");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date =null;
			try {
				date = dateFormat.parse(orderdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String state = request.getParameter("editstate");
			
			OrderService os = new OrderServiceImpl();
			Order order = new Order();
			order.setOrderid(orderid);
			order.setUserid(userid);
			order.setGid(gid);
			order.setTotalprice(totalprice);
			order.setOrderdate(date);
			order.setState(state);
			os.updateOrderByOrder(order);
			response.getWriter().write("1");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
