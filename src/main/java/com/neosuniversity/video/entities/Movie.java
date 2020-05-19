package com.neosuniversity.video.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * 
 * @author hhugohm
 * 
 *         MOVIE Entity that store information <br>
 *         related  title, sinopsys, etc
 *
 */
@Entity
@Table(name="MOVIE",schema="VIDEODB")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MOVIE",nullable=false,unique=false)
	private Long idmovie;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ID_MOVIE")
	private List<Season> season= new ArrayList<>();
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_TYPE_MOVIE")
	private TypeMovie typemovie;
	
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="MOVIE_ACTOR",joinColumns=@JoinColumn(name="ID_MOVIE"),
	inverseJoinColumns=@JoinColumn(name="ID_ACTOR"))
	private Set<Actor> actors = new HashSet<>();
	
	
	@Column(name="TITLE",length=200,nullable=false)
	private String title;
	
	
	@Column(name="SYNOPSIS",length=900,nullable=true)
	private String synopsis;
	
	
	
	@Column(name="DURATION",nullable=true)
	private Date duration;
	
	@Column(name="IMAGE_PATH",length=500,nullable=true)
	private String imagepath;

	public Long getIdmovie() {
		return idmovie;
	}

	public void setIdmovie(Long idmovie) {
		this.idmovie = idmovie;
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
	

	public List<Season> getSeason() {
		return season;
	}

	public void setSeason(List<Season> season) {
		this.season = season;
	}

	public TypeMovie getTypemovie() {
		return typemovie;
	}

	public void setTypemovie(TypeMovie typemovie) {
		this.typemovie = typemovie;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Movie [idmovie=" + idmovie + ", season=" + season + ", typemovie=" + typemovie + ", actors=" + actors
				+ ", title=" + title + ", synopsis=" + synopsis + ", duration=" + duration + ", imagepath=" + imagepath
				+ "]";
	}

	
	

}
