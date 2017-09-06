package org.lanqiao.Dao;

import java.util.List;

import org.lanqiao.entity.Category;


public interface CategoryDao {
	public List<Category> list();
	public Category getCategory(String cid);
	public void deleteCategoryByCid(String cid);
	public void insertCategory(Category category);
	public void updateCategory(String cid,String cname);
}
