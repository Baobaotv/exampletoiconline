package com.toeiconline.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtis {
	private static SessionFactory SessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			
			// create session factory from hibernate.cfg
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("Initial session factory fail");
			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getSessionFactory() {
		return SessionFactory;
	}
}
