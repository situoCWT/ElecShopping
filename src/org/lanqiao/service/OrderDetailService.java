package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.OrderDetail;

public interface OrderDetailService {
	public void insertOrderList(OrderDetail orderdetail);
	public List<OrderDetail> getOrderDetailList();
	public void updateNumber(int number,String orderid);
	public void deleteOrderDetail(String orderid);
	public void deleteOrderDetailByOrderid(String orderid);
	public void updateOrderDetail(OrderDetail orderdetail);
	public void deleteOrderDetailByOrderDetailid(String orderdetailid);
	public OrderDetail getOrderDetail(String orderdetailid);
}
