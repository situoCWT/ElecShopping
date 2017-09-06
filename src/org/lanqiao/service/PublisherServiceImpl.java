package org.lanqiao.service;

import java.util.List;

import org.lanqiao.Dao.PublisherDao;
import org.lanqiao.Dao.PublisherDaoImpl;
import org.lanqiao.entity.Publisher;

public class PublisherServiceImpl implements PublisherService {
	PublisherDao dao = new PublisherDaoImpl();
	@Override
	public Publisher getPublisher(String pid) {
		// TODO Auto-generated method stub
		return dao.getPublisher(pid);
	}
	@Override
	public List<Publisher> getPublisher() {
		// TODO Auto-generated method stub
		return dao.getPublisher();
	}
	@Override
	public void deletePublisher(String pid) {
		dao.deletePublisher(pid);
		
	}
	@Override
	public void insertPublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		dao.insertPublisher(publisher);
	}
	@Override
	public void updatePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		dao.updatePublisher(publisher);
	}

}
