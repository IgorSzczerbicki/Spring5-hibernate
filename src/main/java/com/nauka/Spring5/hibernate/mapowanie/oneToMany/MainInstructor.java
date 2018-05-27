package com.nauka.Spring5.hibernate.mapowanie.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainInstructor {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernateOneToMany.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Instructor instructor = new Instructor("Piotr", "Rudy", "pr@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("geyeTiVi", "ssanie");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.save(instructor);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}