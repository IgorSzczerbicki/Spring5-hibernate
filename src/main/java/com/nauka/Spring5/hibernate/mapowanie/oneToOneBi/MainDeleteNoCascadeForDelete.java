package com.nauka.Spring5.hibernate.mapowanie.oneToOneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteNoCascadeForDelete {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernateOneToOneBi.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			System.out.println(instructorDetail);
			System.out.println(instructorDetail.getInstructor());
			
			if (instructorDetail != null) session.delete(instructorDetail);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}