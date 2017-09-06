package org.lanqiao.service;

import java.util.List;

import org.lanqiao.Dao.SearchDao;
import org.lanqiao.Dao.SearchDaoImpl;
import org.lanqiao.entity.Search;

public class SearchServiceImpl implements SearchService {
	SearchDao dao = new SearchDaoImpl();
	@Override
	public List<Search> getlist() {
		// TODO Auto-generated method stub
		return dao.getlist();
	}

}
