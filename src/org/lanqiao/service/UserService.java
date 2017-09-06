package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.User;

public interface UserService {
	public void insertUser(User user);
	public boolean checkLogin(String uloginid,String upassword);
	public User getUser(String uloginid);
	public void updateUser(User user);
	public List<User> getList();
	public void deleteUser(String userid);
}
