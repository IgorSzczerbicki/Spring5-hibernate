package com.nauka.Spring5.hibernate.mapowanie.ManyToMany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteStudent {

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
			
			List<Student> students = session.createQuery("from Student").getResultList();
			System.out.println(students);
			List<Course> courses = session.createQuery("from Course").getResultList();
			System.out.println(courses);
			
			Student student = session.get(Student.class, 20);
			if (student != null) session.delete(student);
			
			students = session.createQuery("from Student").getResultList();
			System.out.println(students);
			courses = session.createQuery("from Course").getResultList();
			System.out.println(courses);
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}