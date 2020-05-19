package com.neosuniversity.video.util;

import org.hibernate.Session;

import com.neosuniversity.video.entities.UserLogin;

public class InsertUser {

	public static void main(String[] args) {
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();

			UserLogin user = new UserLogin();
			user.setUsername("hhugohm");
			user.setEmail("hhugohm@gmail.com");
			user.setPassword("mypass");
			user.setEnabled(false);
			
			
			session.save(user);
			session.getTransaction().commit();
			HibernateUtil.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
