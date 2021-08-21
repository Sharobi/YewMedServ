package com.sharobi.pharmacy.common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PersistenceListener implements ServletContextListener {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Pharmacy");

	public void contextInitialized(ServletContextEvent sce) {
    System.out.println(sce.getServletContext().getContextPath() + ":: In contextInitialized: "+ entityManagerFactory);
		System.out.println("In contextInitialized: " + entityManagerFactory);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("In contextDestroyed: " + entityManagerFactory.isOpen());
		entityManagerFactory.close();
	}

	public static EntityManagerFactory getEntityManager() {
		return entityManagerFactory;
	}
}
