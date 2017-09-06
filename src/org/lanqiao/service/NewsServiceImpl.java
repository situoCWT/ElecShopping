package org.lanqiao.service;

import java.util.List;

import org.lanqiao.Dao.NewsDao;
import org.lanqiao.Dao.NewsDaoImpl;
import org.lanqiao.entity.News;

public class NewsServiceImpl implements NewsService {
	NewsDao dao = new NewsDaoImpl();
	@Override
	public List<News> newslist() {
		// TODO Auto-generated method stub
		return dao.newslist();
	}

}
