package com.neosuniversity.video.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author hhugohm
 * 
 *         CHAPTER Entity that store information <br>
 *         related  title, duration etc
 *
 */
@Entity
@Table(name="CHAPTER",schema="VIDEODB")
public class Chapter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CHAPTER",nullable=false,unique=false)
	private Long idchapter;
	
	@Column(name="TITLE",length=200,nullable=false)
	private String title;
	
	@Column(name="SYNOPSIS",length=900,nullable=true)
	private String synopsis;
	
	
	@Column(name="DURATION",nullable=true)
	private Date duration;
	
	@Column(name="IMAGE_PATH",length=500,nullable=true)
	private String imagepath;

	public Long getIdchapter() {
		return idchapter;
	}

	public void setIdchapter(Long idchapter) {
		this.idchapter = idchapter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "Chapter [idchapter=" + idchapter + ", title=" + title + ", synopsis=" + synopsis + ", duration="
				+ duration + ", imagepath=" + imagepath + "]";
	}

	
}
