package com.neosuniversity.video.util;

import org.hibernate.Session;

import com.neosuniversity.video.entities.Actor;
import com.neosuniversity.video.entities.Country;


public class InsertActor {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		Actor actor= new Actor();
		actor.setName("BRAT");
		actor.setLasname("PIT");
		
		Country country = Country.builder().description("UNITED STATES").build();
		actor.setCountry(country);
		
		session.save(actor);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();

	}

}
