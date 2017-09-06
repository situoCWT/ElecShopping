package org.lanqiao.Dao;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;

public interface PageInfoDao {
	public PageInfo<Goods> goodslist(String cid,int pagesize,int pageindex);
	public int gettotalnumber(String cid);
	public PageInfo<Goods> getgoodslistbylike(String value,String cid,int pagesize,int pageindex);
}
