package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Publisher;

public interface PublisherService {
	public Publisher getPublisher(String pid);
	public List<Publisher> getPublisher();
	public void deletePublisher(String pid);
	public void insertPublisher(Publisher publisher);
	public void updatePublisher(Publisher publisher);
}
