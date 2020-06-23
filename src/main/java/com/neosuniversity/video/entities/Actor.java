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


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class Actor.
 *
 * @author Neosuniversity
 * @version 1.0
 */
@Entity
@Table(name="ACTOR",schema="VIDEODB")
@JsonPropertyOrder({ "idactor", "name", "lasname", "age","imagepath", "country"})
public class Actor {
	
	/** The idactor. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ACTOR",nullable=false)
	private Long idactor;
	
	
	/** The country. */
	@OneToOne(cascade=CascadeType.ALL,  fetch=FetchType.EAGER)
	@JoinColumn(name = "idcountry")
	private Country country;
	
	/** The name. */
	@Column(name="NAME",length=200,nullable=false)
	private String name;
	
	/** The lasname. */
	@Column(name="LAST_NAME",length=200,nullable=false)
	private String lasname;
	
	/** The age. */
	@Column(name="AGE",nullable=false)
	private int age;
	
	
	/** The imagepath. */
	@Column(name="IMAGE_PATH",length=500,nullable=true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String imagepath;


	/**
	 * Gets the idactor.
	 *
	 * @return the idactor
	 */
	public Long getIdactor() {
		return idactor;
	}


	/**
	 * Sets the idactor.
	 *
	 * @param idactor the new idactor
	 */
	public void setIdactor(Long idactor) {
		this.idactor = idactor;
	}


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
	 * Gets the lasname.
	 *
	 * @return the lasname
	 */
	public String getLasname() {
		return lasname;
	}


	/**
	 * Sets the lasname.
	 *
	 * @param lasname the new lasname
	 */
	public void setLasname(String lasname) {
		this.lasname = lasname;
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
	 * Gets the imagepath.
	 *
	 * @return the imagepath
	 */
	public String getImagepath() {
		return imagepath;
	}


	/**
	 * Sets the imagepath.
	 *
	 * @param imagepath the new imagepath
	 */
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}


	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}


	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(Country country) {
		this.country = country;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Actor [idactor=" + idactor + ", country=" + country + ", name=" + name + ", lasname=" + lasname
				+ ", age=" + age + ", imagepath=" + imagepath + "]";
	}



}
