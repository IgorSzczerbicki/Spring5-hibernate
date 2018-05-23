package com.nauka.Spring5.hibernate.crud;

import java.awt.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			//zmienianie obiektu
			Student student = session.get(Student.class, 3);
			student.setFirstName("Pizza");

			//zmienianie dla listy obiektow
			session.createQuery("update Student s set s.email='test@live.com' where s.email LIKE '%gmail.com'").executeUpdate();

			//wykonanie transakcji
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}