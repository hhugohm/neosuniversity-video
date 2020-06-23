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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * The Class Chapter.
 *
 * @author Neosuniversity
 * @version 1.0
 */
@Entity
@Table(name="CHAPTER",schema="VIDEODB")
public class Chapter {
	
	/** The idchapter. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CHAPTER",nullable=false,unique=false)
	private Long idchapter;
	
	/** The title. */
	@Column(name="TITLE",length=200,nullable=false)
	private String title;
	
	/** The synopsis. */
	@Column(name="SYNOPSIS",length=900,nullable=true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String synopsis;
	
	
	/** The duration. */
	@Column(name="DURATION",nullable=true)
	private Date duration;
	
	/** The imagepath. */
	@Column(name="IMAGE_PATH",length=500,nullable=true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String imagepath;

	/**
	 * Gets the idchapter.
	 *
	 * @return the idchapter
	 */
	public Long getIdchapter() {
		return idchapter;
	}

	/**
	 * Sets the idchapter.
	 *
	 * @param idchapter the new idchapter
	 */
	public void setIdchapter(Long idchapter) {
		this.idchapter = idchapter;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Chapter [idchapter=" + idchapter + ", title=" + title + ", synopsis=" + synopsis + ", duration="
				+ duration + ", imagepath=" + imagepath + "]";
	}

	
}
