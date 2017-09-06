package org.lanqiao.service;

import java.util.List;

import org.lanqiao.Dao.UserDao;
import org.lanqiao.Dao.UserDaoImpl;
import org.lanqiao.entity.User;

public class UserServiceImpl implements UserService{
	UserDao dao = new UserDaoImpl();
	@Override
	public void insertUser(User user) {
		dao.insertUser(user);
	}
	@Override
	public boolean checkLogin(String uloginid, String upassword) {
		// TODO Auto-generated method stub
		return dao.checkLogin(uloginid, upassword);
	}
	@Override
	public User getUser(String uloginid) {
		// TODO Auto-generated method stub
		return dao.getUser(uloginid);
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
		
	}
	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		return dao.getList();
	}
	@Override
	public void deleteUser(String userid) {
		// TODO Auto-generated method stub
		dao.deleteUser(userid);
	}

}
