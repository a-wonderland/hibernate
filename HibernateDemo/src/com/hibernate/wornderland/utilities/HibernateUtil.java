package com.hibernate.wornderland.utilities;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static Configuration config = null;
	public static SessionFactory sessionFactory = null;

	// non-instantiated constructor
	private HibernateUtil() {
	}

	// static factory method for sessionFactory
	public static SessionFactory getSessionFactory() {

		try {
			// singleton
			if (config == null && sessionFactory == null) {
				// hibernate configure
				config = new Configuration();
				config.configure("hibernate.cfg.xml");
				// get sessionFactory
				sessionFactory = config.buildSessionFactory();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);

		}

		return sessionFactory;
	}

}
