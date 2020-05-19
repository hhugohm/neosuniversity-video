package com.neosuniversity.video.util;

import org.hibernate.Session;

import com.neosuniversity.video.entities.UserLogin;
import com.neosuniversity.video.entities.UserInformation;

public class InsertUserInfo {

	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();

			UserLogin dbUser = (UserLogin) session.get(UserLogin.class, "hhugohm");
			UserInformation userInfo = new UserInformation();
			userInfo.setUserName(dbUser.getUsername());
			userInfo.setAge(20);
			userInfo.setName("hugo");
			userInfo.setLastname("hidalgo");

			session.save(userInfo);
			session.getTransaction().commit();

			HibernateUtil.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
