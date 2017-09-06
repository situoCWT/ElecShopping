package org.lanqiao.service;

import java.util.List;

import org.lanqiao.Dao.OrderDetailDao;
import org.lanqiao.Dao.OrderDetailDaoImpl;
import org.lanqiao.entity.OrderDetail;

public class OrderDetailServiceImpl implements OrderDetailService {
	OrderDetailDao dao = new OrderDetailDaoImpl();
	@Override
	public void insertOrderList(OrderDetail orderdetail) {
		dao.insertOrderList(orderdetail);

	}
	@Override
	public List<OrderDetail> getOrderDetailList() {
		// TODO Auto-generated method stub
		return dao.getOrderDetailList();
	}
	@Override
	public void updateNumber(int number, String orderid) {
		dao.updateNumber(number, orderid);
		
	}
	@Override
	public void deleteOrderDetail(String orderid) {
		// TODO Auto-generated method stub
		dao.deleteOrderDetail(orderid);
	}
	@Override
	public void deleteOrderDetailByOrderid(String orderid) {
		// TODO Auto-generated method stub
		dao.deleteOrderDetailByOrderid(orderid);
	}
	@Override
	public void updateOrderDetail(OrderDetail orderdetail) {
		// TODO Auto-generated method stub
		dao.updateOrderDetail(orderdetail);
	}
	@Override
	public void deleteOrderDetailByOrderDetailid(String orderdetailid) {
		// TODO Auto-generated method stub
		dao.deleteOrderDetailByOrderDetailid(orderdetailid);
	}
	@Override
	public OrderDetail getOrderDetail(String orderdetailid) {
		// TODO Auto-generated method stub
		return dao.getOrderDetail(orderdetailid);
	}

}
