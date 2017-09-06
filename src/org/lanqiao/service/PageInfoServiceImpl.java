package org.lanqiao.service;

import org.lanqiao.Dao.PageInfoDao;
import org.lanqiao.Dao.PageInfoDaoImpl;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;

public class PageInfoServiceImpl implements PageInfoService {
	PageInfoDao dao = new PageInfoDaoImpl();

	@Override
	public PageInfo<Goods> goodslist(String cid, int pagesize, int pageindex) {
		// TODO Auto-generated method stub
		return dao.goodslist(cid, pagesize, pageindex);
	}

	@Override
	public PageInfo<Goods> getgoodslistbylike(String value, String cid,
			int pagesize, int pageindex) {
		// TODO Auto-generated method stub
		return dao.getgoodslistbylike(value, cid, pagesize, pageindex);
	}

	@Override
	public int gettotalnumber(String cid) {
		
		return dao.gettotalnumber(cid);
	}


}
