package com.nauka.Spring5.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//kasowanie obiektu
			Student student = session.get(Student.class, 2);
			if (student != null) session.delete(student);
			
			//zapytanie usuwaj¹ce
			session.createQuery("delete from Student where id =4").executeUpdate();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}