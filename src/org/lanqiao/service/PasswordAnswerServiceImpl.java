package org.lanqiao.service;

import org.lanqiao.Dao.PasswordAnswerDao;
import org.lanqiao.Dao.PasswordAnswerDaoImpl;
import org.lanqiao.entity.PasswordAnswer;


public class PasswordAnswerServiceImpl implements PasswordAnswerService {
	PasswordAnswerDao dao = new PasswordAnswerDaoImpl();
	@Override
	public void insertPasswordAnswer(PasswordAnswer passwordanswer) {
		dao.insertPasswordAnswer(passwordanswer);

	}
	@Override
	public void updatePasswordAnswer(PasswordAnswer passwordanswer) {
		dao.updatePasswordAnswer(passwordanswer);
		
	}
	@Override
	public PasswordAnswer getPasswordAnswer(String userid) {
		return dao.getPasswordAnswer(userid);
	}
	@Override
	public void deletePasswordAnswerByUserid(String userid) {
		dao.deletePasswordAnswerByUserid(userid);
		
	}


}
