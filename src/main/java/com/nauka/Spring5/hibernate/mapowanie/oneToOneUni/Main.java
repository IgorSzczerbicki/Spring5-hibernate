package com.nauka.Spring5.hibernate.mapowanie.oneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernateOneToOneUni.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			InstructorDetail instructorDetail = new InstructorDetail("www.jk.com", "Tennis");
			Instructor instructor = new Instructor("Jan", "Kowalski", "jk@gmail.com");
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}