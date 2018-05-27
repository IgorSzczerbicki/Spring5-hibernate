package com.nauka.Spring5.hibernate.mapowanie.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCourses {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernateOneToMany.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, 1);

			Course course1 = new Course("kurs 1");
			Course course2 = new Course("kurs 2");

			instructor.add(course1);
			instructor.add(course2);

			session.save(course1);
			session.save(course2);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}