package com.nauka.Spring5.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent_HQL {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//pobieranie wszystkich studentow
			List<Student> students = session.createQuery("from Student").getResultList();
			displayStudents(students);
			
			//pobieranie studentow o nazwisku Kowalski
			System.out.println("Kowalski");
			students = session.createQuery("from Student s where s.lastName='Kowalski'").getResultList();
			displayStudents(students);
			
			//pobieranie studentow z email outlook.com
			System.out.println("outlook.com");
			students = session.createQuery("from Student s where s.email LIKE '%outlook.com'").getResultList();
			displayStudents(students);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student tmpStudent: students) {
			System.out.println(tmpStudent);
		}
	}
}