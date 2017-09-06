package org.lanqiao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("context监听器消亡");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("context监听器创建");
		
	}

}
