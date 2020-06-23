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
 * The Class Season.
 * 
 * @author Neosuniversity
 * @version 1.0
 */
@Entity
@Table(name="SEASON",schema="VIDEODB")
@JsonPropertyOrder({ "idseason", "title", "synopsis", "chapters" })
public class Season {
	
	/** The idseason. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SEASON",nullable=false,unique=false)
	private Long idseason;
	
	
	/** The chapters. */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ID_SEASON")
	private List<Chapter> chapters= new ArrayList<>();
	
	/** The title. */
	@Column(name="TITLE",length=200,nullable=false)
	private String title;
	
	/** The synopsis. */
	@Column(name="SYNOPSIS",length=900,nullable=true)
	private String synopsis;

	/**
	 * Gets the idseason.
	 *
	 * @return the idseason
	 */
	public Long getIdseason() {
		return idseason;
	}

	/**
	 * Sets the idseason.
	 *
	 * @param idseason the new idseason
	 */
	public void setIdseason(Long idseason) {
		this.idseason = idseason;
	}

	/**
	 * Gets the chapters.
	 *
	 * @return the chapters
	 */
	public List<Chapter> getChapters() {
		return chapters;
	}

	/**
	 * Sets the chapters.
	 *
	 * @param chapters the new chapters
	 */
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Season [idseason=" + idseason + ", chapters=" + chapters + ", title=" + title + ", synopsis=" + synopsis
				+ "]";
	}
	
	
	
	

}
