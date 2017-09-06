package org.lanqiao.service;

import java.util.List;

import org.lanqiao.Dao.CategoryDao;
import org.lanqiao.Dao.CategoryDaoImpl;
import org.lanqiao.entity.Category;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao dao = new CategoryDaoImpl();
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}
	@Override
	public Category getCategory(String cid) {
		// TODO Auto-generated method stub
		return dao.getCategory(cid);
	}
	@Override
	public void deleteCategoryByCid(String cid) {
		// TODO Auto-generated method stub
		dao.deleteCategoryByCid(cid);
	}
	@Override
	public void insertCategory(Category category) {
		// TODO Auto-generated method stub
		dao.insertCategory(category);
	}
	@Override
	public void updateCategory(String cid, String cname) {
		// TODO Auto-generated method stub
		dao.updateCategory(cid, cname);
	}

}
