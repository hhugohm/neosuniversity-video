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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;




/**
 * The Class Movie.
 * 
 * @author Neosuniversity
 * @version 1.0
 */
@Entity
@Table(name="MOVIE",schema="VIDEODB")
@JsonPropertyOrder({ "idmovie", "title", "synopsis", "duration", "imagepath","typemovie","season", "actors" })
public class Movie {
	
	/** The idmovie. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MOVIE",nullable=false,unique=false)
	private Long idmovie;
	
	
	/** The season. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ID_MOVIE")
	private List<Season> season= new ArrayList<>();
	
	
	/** The typemovie. */
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_TYPE_MOVIE")
	private TypeMovie typemovie;
	
	
	/** The actors. */
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="MOVIE_ACTOR",joinColumns=@JoinColumn(name="ID_MOVIE"),
	inverseJoinColumns=@JoinColumn(name="ID_ACTOR"))
	@JsonProperty("actors")
	private Set<Actor> actors = new HashSet<>();
	
	
	/** The title. */
	@Column(name="TITLE",length=200,nullable=false)
	private String title;
	
	
	/** The synopsis. */
	@Column(name="SYNOPSIS",length=900,nullable=true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String synopsis;
	
	/** The duration. */
	@DateTimeFormat(pattern = "HH:mm:ss", iso = ISO.DATE_TIME)
	@JsonFormat( shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
	@Column(name="DURATION",nullable=true)
	private Date duration;
	
	
	/** The imagepath. */
	@Column(name="IMAGE_PATH",length=500,nullable=true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String imagepath;

	/**
	 * Gets the idmovie.
	 *
	 * @return the idmovie
	 */
	public Long getIdmovie() {
		return idmovie;
	}

	/**
	 * Sets the idmovie.
	 *
	 * @param idmovie the new idmovie
	 */
	public void setIdmovie(Long idmovie) {
		this.idmovie = idmovie;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the synopsis.
	 *
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * Sets the synopsis.
	 *
	 * @param synopsis the new synopsis
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public Date getDuration() {
		return duration;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration the new duration
	 */
	public void setDuration(Date duration) {
		this.duration = duration;
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
	 * Gets the season.
	 *
	 * @return the season
	 */
	public List<Season> getSeason() {
		return season;
	}

	/**
	 * Sets the season.
	 *
	 * @param season the new season
	 */
	public void setSeason(List<Season> season) {
		this.season = season;
	}

	/**
	 * Gets the typemovie.
	 *
	 * @return the typemovie
	 */
	public TypeMovie getTypemovie() {
		return typemovie;
	}

	/**
	 * Sets the typemovie.
	 *
	 * @param typemovie the new typemovie
	 */
	public void setTypemovie(TypeMovie typemovie) {
		this.typemovie = typemovie;
	}

	/**
	 * Gets the actors.
	 *
	 * @return the actors
	 */
	public Set<Actor> getActors() {
		return actors;
	}

	/**
	 * Sets the actors.
	 *
	 * @param actors the new actors
	 */
	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie [idmovie=" + idmovie + ", season=" + season + ", typemovie=" + typemovie + ", actors=" + actors
				+ ", title=" + title + ", synopsis=" + synopsis + ", duration=" + duration + ", imagepath=" + imagepath
				+ "]";
	}

	
	

}
