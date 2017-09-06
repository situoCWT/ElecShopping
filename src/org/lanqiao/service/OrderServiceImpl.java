package org.lanqiao.service;

import java.util.List;

import org.lanqiao.Dao.OrderDao;
import org.lanqiao.Dao.OrderDaoImpl;
import org.lanqiao.entity.Order;

public class OrderServiceImpl implements OrderService {
	OrderDao dao = new OrderDaoImpl();
	@Override
	public void insertOrderList(Order order) {
		dao.insertOrderList(order);

	}
	@Override
	public List<Order> getOrderList() {
		// TODO Auto-generated method stub
		return dao.getOrderList();
	}
	@Override
	public void updateTatolPrice(double totalprice, String orderid) {
		// TODO Auto-generated method stub
		dao.updateTatolPrice(totalprice, orderid);
	}
	@Override
	public void deleteOrder(String gid) {
		// TODO Auto-generated method stub
		dao.deleteOrder(gid);
	}
	@Override
	public Order getOrder(String gid) {
		// TODO Auto-generated method stub
		return dao.getOrder(gid);
	}
	@Override
	public void deleteOrderByUserid(String userid) {
		// TODO Auto-generated method stub
		dao.deleteOrderByUserid(userid);
	}
	@Override
	public List<Order> getOrderList(String userid) {
		// TODO Auto-generated method stub
		return dao.getOrderList(userid);
	}
	@Override
	public void deleteOrderByOrderid(String orderid) {
		// TODO Auto-generated method stub
		dao.deleteOrderByOrderid(orderid);
	}
	@Override
	public void updateOrderByOrder(Order order) {
		// TODO Auto-generated method stub
		dao.updateOrderByOrder(order);
	}
	@Override
	public Order getOrderByOrderid(String orderid) {
		// TODO Auto-generated method stub
		return dao.getOrderByOrderid(orderid);
	}
	@Override
	public void insertOrderListByGetDate(Order order) {
		// TODO Auto-generated method stub
		dao.insertOrderListByGetDate(order);
	}
	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		dao.updateState();
	}

}
