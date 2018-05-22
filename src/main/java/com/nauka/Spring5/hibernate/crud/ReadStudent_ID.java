package com.nauka.Spring5.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent_ID {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Student student = new Student("John", "Lewinski", "jl@gmail.com");

		try {
			//zapisywanie studenta
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();

			//odczytywanie studenta
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student newStudent = session.get(Student.class, student.getId());
			System.out.println(newStudent.getLastName());		
		} finally {
			factory.close();
		}
	}
}