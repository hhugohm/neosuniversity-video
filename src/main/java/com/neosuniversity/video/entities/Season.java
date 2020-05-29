package com.neosuniversity.video.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * 
 * @author hhugohm
 * 
 *         SEASON Entity that store information <br>
 *         related  type of season
 *
 */
@Entity
@Table(name="SEASON",schema="VIDEODB")
@JsonPropertyOrder({ "idseason", "title", "synopsis", "chapters" })
public class Season {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SEASON",nullable=false,unique=false)
	private Long idseason;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ID_SEASON")
	private List<Chapter> chapters= new ArrayList<>();
	
	@Column(name="TITLE",length=200,nullable=false)
	private String title;
	
	@Column(name="SYNOPSIS",length=900,nullable=true)
	private String synopsis;

	public Long getIdseason() {
		return idseason;
	}

	public void setIdseason(Long idseason) {
		this.idseason = idseason;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
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

	@Override
	public String toString() {
		return "Season [idseason=" + idseason + ", chapters=" + chapters + ", title=" + title + ", synopsis=" + synopsis
				+ "]";
	}
	
	
	
	

}
