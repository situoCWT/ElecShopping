package org.lanqiao.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
//		System.out.println("request监听器消亡");

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
//		System.out.println("request监听器创建");
		
	}

}
