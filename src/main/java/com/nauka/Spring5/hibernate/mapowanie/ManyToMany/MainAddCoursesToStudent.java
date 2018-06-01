package com.nauka.Spring5.hibernate.mapowanie.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainAddCoursesToStudent {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernateManyToMany.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 19);
			Course course = new Course("Nowy kurs");
			student.addCourse(course);
			
			session.save(course);
			session.getTransaction().commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}