package org.lanqiao.mapper;

import java.util.List;

import org.junit.Test;
import org.lanqiao.entity.Publisher;

public interface PublisherMapper {
	public Publisher getPublisher(String pid);
	public List<Publisher> getAllPublisher();
	public void deletePublisher(String pid);
	public void insertPublisher(Publisher publisher);
	public void updatePublisher(Publisher publisher);
}
