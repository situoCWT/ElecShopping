package org.lanqiao.service;

import java.util.List;

import org.lanqiao.Dao.CartDao;
import org.lanqiao.Dao.CartDaoImpl;
import org.lanqiao.entity.Cart;

public class CartServiceImpl implements CartService {
	CartDao dao = new CartDaoImpl();
	@Override
	public List<Cart> getCartList() {
		// TODO Auto-generated method stub
		return dao.getCartList();
	}

}
