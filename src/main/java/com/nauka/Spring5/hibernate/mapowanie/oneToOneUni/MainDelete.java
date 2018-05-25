package com.nauka.Spring5.hibernate.mapowanie.oneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernateOneToOneUni.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 1);
			if (instructor != null) session.delete(instructor);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
