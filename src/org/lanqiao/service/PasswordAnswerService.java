package org.lanqiao.service;

import org.lanqiao.entity.PasswordAnswer;


public interface PasswordAnswerService {
	public void insertPasswordAnswer(PasswordAnswer passwordanswer);
	public void updatePasswordAnswer(PasswordAnswer passwordanswer);
	public PasswordAnswer getPasswordAnswer(String userid);
	public void deletePasswordAnswerByUserid(String userid);
}
