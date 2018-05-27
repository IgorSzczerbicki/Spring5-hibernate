package com.nauka.Spring5.hibernate.mapowanie.oneToMany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainGetInstructorCourses {

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
			Instructor instructor = session.get(Instructor.class, 1);
			
			System.out.println(instructor.getCourses());
			session.getTransaction().commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}