package com.nauka.Spring5.hibernate.mapowanie.oneToOneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernateOneToOneBi.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Instructor instructor = new Instructor("Jan", "Kowal", "jk@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube", "hobby");
			instructor.setInstructorDetail(instructorDetail);
			
			session.save(instructor);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}