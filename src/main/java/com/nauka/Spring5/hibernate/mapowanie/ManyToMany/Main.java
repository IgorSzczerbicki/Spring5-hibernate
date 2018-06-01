package com.nauka.Spring5.hibernate.mapowanie.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

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
			
			Course course1 = new Course("Kurs 1");
			Course course2 = new Course("Kurs 2");
			Course course3 = new Course("Kurs 3");
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			Student student1 = new Student("Jan", "Kowal", "jk@gmail.com");
			Student student2 = new Student("Anna", "Mysz", "am@gmail.com");
			
			course1.addStudent(student1);
			course1.addStudent(student2);
			course2.addStudent(student2);
			course3.addStudent(student2);
						
			session.save(student1);
			session.save(student2);
			
			session.getTransaction().commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}