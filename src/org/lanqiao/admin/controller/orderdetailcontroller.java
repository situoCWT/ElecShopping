package org.lanqiao.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.OrderDetail;
import org.lanqiao.service.OrderDetailService;
import org.lanqiao.service.OrderDetailServiceImpl;

import com.google.gson.Gson;

@WebServlet("/orderdetailcontroller.do")
public class orderdetailcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type!=null&&type.equals("search"))
		{
			OrderDetailService ods = new OrderDetailServiceImpl();
			List<OrderDetail> list = ods.getOrderDetailList();
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(list));
		}
		else if(type!=null&&type.equals("del")){
			String orderdetailid = request.getParameter("orderdetailid");
			OrderDetailService ods = new OrderDetailServiceImpl();
			ods.deleteOrderDetailByOrderDetailid(orderdetailid);
			response.getWriter().write("1");
		}
		else if(type!=null&&type.equals("add")){
			String orderdetailid = UUID.randomUUID().toString();
			String gtitle = request.getParameter("addgtitle");
			String gsaleprice = request.getParameter("addgsaleprice");
			String gnumber = request.getParameter("addgnumber");
			String orderid = request.getParameter("addorderid");
			OrderDetail chkorderdetail = null;
			OrderDetailService ods = new OrderDetailServiceImpl();
			chkorderdetail = ods.getOrderDetail(orderdetailid);
			if(chkorderdetail == null)
			{
				OrderDetail orderdetail = new OrderDetail();
				orderdetail.setOrderdetailid(orderdetailid);
				orderdetail.setGtitle(gtitle);
				orderdetail.setGsaleprice(Double.parseDouble(gsaleprice));
				orderdetail.setGnumber(Integer.parseInt(gnumber));
				orderdetail.setOrderid(orderid);
				ods.insertOrderList(orderdetail);
				response.getWriter().write("1");
			}
			if(chkorderdetail != null)
			{
				response.getWriter().write("0");
			}
		}
		else if(type!=null&&type.equals("edit")){
			String orderdetailid = request.getParameter("editorderdetailid");
			String gtitle = request.getParameter("editgtitle");
			String gsaleprice = request.getParameter("editgsaleprice");
			String gnumber = request.getParameter("editgnumber");
			String orderid = request.getParameter("editorderid");
			OrderDetailService ods = new OrderDetailServiceImpl();
			OrderDetail orderdetail = new OrderDetail();
			orderdetail.setOrderdetailid(orderdetailid);
			orderdetail.setGtitle(gtitle);
			orderdetail.setGsaleprice(Double.parseDouble(gsaleprice));
			orderdetail.setGnumber(Integer.parseInt(gnumber));
			orderdetail.setOrderid(orderid);
			ods.updateOrderDetail(orderdetail);
			response.getWriter().write("1");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
