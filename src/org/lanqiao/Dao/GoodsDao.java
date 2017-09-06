package org.lanqiao.Dao;

import java.util.List;

import org.lanqiao.entity.Goods;

public interface GoodsDao {
	public List<Goods> goodslist(String gid);
	public Goods getgoods(String gid);
	public List<Goods> allgoodslist();
	public List<Goods> getgoodslistbycid(String cid);
	public void delectgoodsbygid(String gid);
	public void insertgood(Goods good);
	public void updategood(Goods good);
	public List<Goods> getgoodslistbylike(String value,String cid);
}
