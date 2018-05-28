package com.nauka.Spring5.hibernate.mapowanie.eagerLazyFetching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MainJoinFetch {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernateOneToMany.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//przygotowania zapytanie HQL
			Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses"
					+ " where i.id=:instructorId", Instructor.class);
			//ustawienie parametru zapytanie
			query.setParameter("instructorId", 1);
			
			//wykonanie zapytania
			Instructor instructor = query.getSingleResult();
			System.out.println(instructor);
			session.getTransaction().commit();
			session.close();
			//zapytanie o dane po zamkniêciu sesji, dzieki pobraniu ich w zapytaniu
			System.out.println(instructor.getCourses());
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}