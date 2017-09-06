package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Goods;

public interface GoodsService {
	public  List<Goods> goodslist(String gid);
	public  List<Goods> allgoodslist();
	public List<Goods> getgoodslistbycid(String cid);
	public void delectgoodsbygid(String gid);
	public void insertgood(Goods good);
	public Goods getgoods(String gid);
	public void updategood(Goods good);
	public List<Goods> getgoodslistbylike(String value,String cid);
}
