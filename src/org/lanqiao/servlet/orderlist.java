package org.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Cart;
import org.lanqiao.service.CartService;
import org.lanqiao.service.CartServiceImpl;

@WebServlet("/orderlist.do")
public class orderlist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartService cs1 = new CartServiceImpl();
		List<Cart> list1 = cs1.getCartList();
		request.setAttribute("list1", list1);
		request.getRequestDispatcher("/WEB-INF/orderlist.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
