package com.nauka.Spring5.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student tmpStudent = new Student("Rafal", "Kloc", "rk@outlook.com");
			session.beginTransaction();
			session.save(tmpStudent);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}