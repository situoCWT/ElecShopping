package org.lanqiao.service;

import java.util.List;

import org.lanqiao.Dao.GoodsDao;
import org.lanqiao.Dao.GoodsDaoImpl;
import org.lanqiao.entity.Goods;

public class GoodsServiceImpl implements GoodsService {
	GoodsDao dao = new GoodsDaoImpl();
	@Override
	public List<Goods> goodslist(String gid) {
		
		return dao.goodslist(gid);
	}
	@Override
	public List<Goods> allgoodslist() {
		// TODO Auto-generated method stub
		return dao.allgoodslist();
	}
	@Override
	public List<Goods> getgoodslistbycid(String cid) {
		// TODO Auto-generated method stub
		return dao.getgoodslistbycid(cid);
	}
	@Override
	public void delectgoodsbygid(String gid) {
		dao.delectgoodsbygid(gid);
		
	}
	@Override
	public void insertgood(Goods good) {
		dao.insertgood(good);
		
	}
	@Override
	public Goods getgoods(String gid) {
		// TODO Auto-generated method stub
		return dao.getgoods(gid);
	}
	@Override
	public void updategood(Goods good) {
		// TODO Auto-generated method stub
		dao.updategood(good);
	}
	@Override
	public List<Goods> getgoodslistbylike(String value, String cid) {
		// TODO Auto-generated method stub
		return dao.getgoodslistbylike(value, cid);
	}

}
