package org.lanqiao.service;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;

public interface PageInfoService {
	public PageInfo<Goods> goodslist(String cid,int pagesize,int pageindex);
	public PageInfo<Goods> getgoodslistbylike(String value,String cid,int pagesize,int pageindex);
	public int gettotalnumber(String cid);
}
