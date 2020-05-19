package com.neosuniversity.video.util;

import org.hibernate.Session;

import com.neosuniversity.video.entities.UserLogin;
import com.neosuniversity.video.entities.Authority;
import com.neosuniversity.video.entities.AuthorityId;
import com.neosuniversity.video.entities.UserInformation;

public class InsertMix {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();

		UserLogin user = new UserLogin();
		user.setUsername("hhugohm");
		user.setEmail("hhugohm@gmail.com");
		user.setPassword("mypass");
		user.setEnabled(false);
		
		UserInformation userInfo = new UserInformation();
		userInfo.setUserName(user.getUsername());
		userInfo.setAge(20);
		userInfo.setName("hugo");
		userInfo.setLastname("hidalgo");
		
		Authority authority= new Authority();
		AuthorityId authorityId = new AuthorityId();
		authorityId.setUsername(user.getUsername());
		authorityId.setAuthority("ADMIN");
		authority.setAuthorityId(authorityId);
		//authority.setUserName(user.getUserName());
		//authority.setAuthority("ADMIN");
		
		user.setUserInfo(userInfo);
		user.setAuthority(authority);
		
		user.setUserInfo(userInfo);
		
		session.save(user);
		session.getTransaction().commit();
		HibernateUtil.shutdown();

	}

}
