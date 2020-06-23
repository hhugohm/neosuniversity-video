/******************************************************************************************
Copyright (c) 2020 NeosSoftware Corporation

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is furnished
to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
************************************************************************************************/
package com.neosuniversity.video.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class UserInformation.
 * 
 * @author Neosuniversity
 * @version 1.0
 * 
 */
@Entity
@Table(name="USER_INFO",schema="VIDEODB")
public class UserInformation {
	

	/** The user name. */
	@Id
	@Column(name="USER_NAME",length=50,nullable=false,unique=true)
	private String userName;
	
	
	/** The name. */
	@Column(name="NAME",length=200,nullable=false)
	private String name;
	
	
	/** The lastname. */
	@Column(name="LAST_NAME",length=200, nullable=false)
	private String lastname;
	
	
	/** The age. */
	@Column(name="AGE",length=3,nullable=true)
	private int age;


	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}


	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
