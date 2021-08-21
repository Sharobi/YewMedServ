package com.sharobi.pharmacy.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Initializer implements ServletContextListener {
	private static final Logger logger = LogManager
			.getLogger(Initializer.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		logger.info("Context destroyed[-] : "
				+ arg0.getServletContext().getContextPath());
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// EntityManagerFactory entityManagerFactory = null;
		try {
			logger.debug("Initializing DB connection");
			DbConnection.init();
		} catch (Throwable t) {
			logger.error("Exception: ", t);
		}
		logger.info("Context initialized[+] : "
				+ arg0.getServletContext().getContextPath());
	}
}
