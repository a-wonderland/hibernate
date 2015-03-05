package com.hibernate.wonderland.utilities;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * This class provided static factory method to configure Hibernate. Provided
 * non-instantiated constructor.
 * 
 * @author Alice
 */
public class HibernateUtil {

	/**
	 * Non-instantiated constructor
	 */
	private HibernateUtil() {
	}

	/**
	 * This static factory method provided for configure Hibernate and build SessionFactory.
	 * 
	 * @exception HibernateException
	 * @return sessionFactory that is singleton object
	 */
	public static SessionFactory getSessionFactory() {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		try {
			// singleton
			if (config == null && sessionFactory == null){
				config = new Configuration();
				// configure for desired file name
				config.configure("hibernate.cfg.xml");
				sessionFactory = config.buildSessionFactory();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return sessionFactory;

	}
	
	/**
	 * This static factory method provided for configure Hibernate Annotation and build SessionFactory.
	 * 
	 * @exception HibernateException
	 * @return sessionFactory that is singleton object
	 */
	public static SessionFactory getSessionFactoryAnno() {
		AnnotationConfiguration config = null;
		SessionFactory sessionFactory = null;
		try {
			// singleton
			if (config == null && sessionFactory == null){
				config = new AnnotationConfiguration();
				// configure for desired file name
				config.configure("hibernate.cfg.xml");
				sessionFactory = config.buildSessionFactory();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return sessionFactory;

	}
}
