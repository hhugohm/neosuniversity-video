package com.neosuniversity.video.util;

import org.hibernate.Session;

import com.neosuniversity.video.entities.UserLogin;

public class Select {

	public static void main(String[] args) {

		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();

		
			UserLogin dbUser = (UserLogin) session.get(UserLogin.class, "hhugohm");
			System.out.println("#########: " +dbUser.getAuthority().getAuthorityId().getAuthority());
			
			System.out.println("#########: " + dbUser.toString());

			HibernateUtil.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
