package com.neosuniversity.video.util;

import org.hibernate.Session;

import com.neosuniversity.video.entities.TypeMovie;

public class InsertTypeMovie {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		TypeMovie typeMovie1= new TypeMovie();
		TypeMovie typeMovie2= new TypeMovie();
		typeMovie1.setType("MOVIE");
		typeMovie2.setType("SERIE");
		
		
		session.save(typeMovie1);
		session.save(typeMovie2);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();

	}

}
