package org.lanqiao.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session监听器创建");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session监听器消亡");

	}

}
