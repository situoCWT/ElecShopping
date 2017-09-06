package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Order;

public interface OrderService {
	public void insertOrderList(Order order);
	public List<Order> getOrderList();
	public void updateTatolPrice(double totalprice,String orderid);
	public void deleteOrder(String gid);
	public Order getOrder(String gid);
	public void deleteOrderByUserid(String userid);
	public List<Order> getOrderList(String userid);
	public void deleteOrderByOrderid(String orderid);
	public void updateOrderByOrder(Order order);
	public Order getOrderByOrderid(String orderid);
	public void insertOrderListByGetDate(Order order);
	public void updateState();
}
