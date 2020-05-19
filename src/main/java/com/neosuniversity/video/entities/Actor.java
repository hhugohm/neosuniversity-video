package com.neosuniversity.video.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author hhugohm
 * 
 *         ACTOR Entity that store information <br>
 *         related name, etc
 *
 */
@Entity
@Table(name="ACTOR",schema="VIDEODB")
public class Actor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ACTOR",nullable=false,unique=false)
	private Long idactor;
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idcountry")
	private Country country;
	
	@Column(name="NAME",length=200,nullable=false)
	private String name;
	
	@Column(name="LAST_NAME",length=200,nullable=false)
	private String lasname;
	
	@Column(name="AGE",nullable=false)
	private int age;
	
	
	@Column(name="IMAGE_PATH",length=500,nullable=true)
	private String imagepath;


	public Long getIdactor() {
		return idactor;
	}


	public void setIdactor(Long idactor) {
		this.idactor = idactor;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLasname() {
		return lasname;
	}


	public void setLasname(String lasname) {
		this.lasname = lasname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getImagepath() {
		return imagepath;
	}


	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Actor [idactor=" + idactor + ", country=" + country + ", name=" + name + ", lasname=" + lasname
				+ ", age=" + age + ", imagepath=" + imagepath + "]";
	}



}
