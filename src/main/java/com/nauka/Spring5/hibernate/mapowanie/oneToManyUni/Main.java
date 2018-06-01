package com.nauka.Spring5.hibernate.mapowanie.oneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernateOneToMany.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course course = session.get(Course.class, 1);
			Review review = new Review("Recenzja super");
			course.addReview(review);
			
			session.save(course);
			session.getTransaction().commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}