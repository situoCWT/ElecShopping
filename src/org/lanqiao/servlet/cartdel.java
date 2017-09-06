package org.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Cart;
import org.lanqiao.entity.Order;
import org.lanqiao.entity.User;
import org.lanqiao.service.CartService;
import org.lanqiao.service.CartServiceImpl;
import org.lanqiao.service.OrderDetailService;
import org.lanqiao.service.OrderDetailServiceImpl;
import org.lanqiao.service.OrderService;
import org.lanqiao.service.OrderServiceImpl;
import org.lanqiao.service.UserService;
import org.lanqiao.service.UserServiceImpl;


@WebServlet("/cartdel.do")
public class cartdel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object object = request.getSession().getAttribute("uloginid");
		String uloginid = object.toString();
		UserService us = new UserServiceImpl();
		User user = us.getUser(uloginid);
		String gid = request.getParameter("gid");
		OrderService os = new OrderServiceImpl();
		OrderDetailService ods = new OrderDetailServiceImpl();
		Order order = os.getOrder(gid);
		ods.deleteOrderDetail(order.getOrderid());
		os.deleteOrder(gid);
		CartService cs = new CartServiceImpl();
		List<Cart> cartlist = cs.getCartList();
		request.setAttribute("cartlist", cartlist);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
