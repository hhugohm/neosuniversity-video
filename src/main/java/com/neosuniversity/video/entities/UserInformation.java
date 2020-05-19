package com.neosuniversity.video.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author hhugohm
 * 
 * USER_INFO Entity that store information <br>
 * regarding user
 *
 */
@Entity
@Table(name="USER_INFO",schema="VIDEODB")
public class UserInformation {
	

	@Id
	@Column(name="USER_NAME",length=50,nullable=false,unique=true)
	private String userName;
	
	
	@Column(name="NAME",length=200,nullable=false)
	private String name;
	
	
	@Column(name="LAST_NAME",length=200, nullable=false)
	private String lastname;
	
	
	@Column(name="AGE",length=3,nullable=true)
	private int age;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", name=" + name + ", lastname=" + lastname + ", age=" + age + "]";
	}
	
	//@OneToOne(cascade=CascadeType.ALL)
		//@JoinColumn(name="userName")
		//@OneToOne(mappedBy = "userInfo", fetch = FetchType.EAGER)
		//public User user;
		
		//@OneToOne(mappedBy = "userInfo", fetch = FetchType.EAGER)
		//public User user;
}
