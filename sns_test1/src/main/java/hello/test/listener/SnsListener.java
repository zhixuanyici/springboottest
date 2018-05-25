package hello.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnsListener implements ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(SnsListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("监听到事件");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("初始化监听器------");
	}

}
