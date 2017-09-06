package org.lanqiao.Dao;

import org.lanqiao.entity.PasswordAnswer;

public interface PasswordAnswerDao {
	public void insertPasswordAnswer(PasswordAnswer passwordanswer);
	public void updatePasswordAnswer(PasswordAnswer passwordanswer);
	public PasswordAnswer getPasswordAnswer(String userid);
	public void deletePasswordAnswerByUserid(String userid);
}
