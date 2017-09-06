package org.lanqiao.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Cart;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.Order;
import org.lanqiao.entity.OrderDetail;
import org.lanqiao.entity.User;
import org.lanqiao.service.CartService;
import org.lanqiao.service.CartServiceImpl;
import org.lanqiao.service.GoodsService;
import org.lanqiao.service.GoodsServiceImpl;
import org.lanqiao.service.OrderDetailService;
import org.lanqiao.service.OrderDetailServiceImpl;
import org.lanqiao.service.OrderService;
import org.lanqiao.service.OrderServiceImpl;
import org.lanqiao.service.UserService;
import org.lanqiao.service.UserServiceImpl;


@WebServlet("/cart.do")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object object = request.getSession().getAttribute("uloginid");
		String gid = request.getParameter("gid");
		String uloginid;
		if(object==null)
		{
			uloginid = null;
		}
		else{
			uloginid = object.toString();
		}
		if(uloginid==null)
		{
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
		else
		{
			if(gid!=null)
			{
				GoodsService gs = new GoodsServiceImpl();
				List<Goods> goods = gs.goodslist(gid);
				Goods good = goods.get(0);
				UserService us = new UserServiceImpl();
				User user = us.getUser(uloginid);
				
				OrderService os = new OrderServiceImpl();
				OrderDetailService ods = new OrderDetailServiceImpl();
				
				boolean sign = false;
				CartService cs = new CartServiceImpl();
				List<Cart> cartlist = cs.getCartList();
				for(int i=0;i<cartlist.size();i++)
				{
					if(cartlist.get(i).getGid().equals(gid))
					{
						
						os.updateTatolPrice((cartlist.get(i).getGnumber()+1)*cartlist.get(i).getGsaleprice(), cartlist.get(i).getOrderid());
						ods.updateNumber(cartlist.get(i).getGnumber()+1, cartlist.get(i).getOrderid());
						cartlist = cs.getCartList();
						sign=true;
						break;
					}
				}
				if(sign==false)
				{
					String userid = user.getUserid();
					String orderid = UUID.randomUUID().toString();
					double totalpricce = good.getGsaleprice();
					Date orderdate = new Date();
					String state = "0";
					Order order = new Order(orderid, userid, gid, totalpricce, orderdate, state);
					
					os.insertOrderList(order);
					
					String orderdetailid = UUID.randomUUID().toString();
					String gtitle = good.getGtitle();
					double gsaleprice = good.getGsaleprice();
					int gmunber =1;
					OrderDetail orderdetail = new OrderDetail(orderdetailid, gtitle, gsaleprice, gmunber, orderid);
					
					ods.insertOrderList(orderdetail);
				}
				request.setAttribute("cartlist", cartlist);
				request.setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/addsuccess.jsp").forward(request, response);
			}
			else
			{
				UserService us = new UserServiceImpl();
				User user = us.getUser(uloginid);
				CartService cs = new CartServiceImpl();
				List<Cart> cartlist = cs.getCartList();
				request.setAttribute("cartlist", cartlist);
				request.setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
