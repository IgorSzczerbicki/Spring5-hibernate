package com.nauka.Spring5.hibernate.mapowanie.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteCourse {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernateOneToMany.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Course course = session.get(Course.class, 2);
			System.out.println(course);
			
			if (course != null) session.delete(course);
			session.getTransaction().commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}