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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class TypeMovie.
 * 
 * @author Neosuniversity
 * @version 1.0 
 * 
 */
@Entity
@Table(name="TYPE_MOVIE",schema="VIDEODB")
public class TypeMovie {
	
	
	/** The idtypemovie. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TYPE_MOVIE",nullable=false)
	private Long idtypemovie;
	
	
	
	/** The type. */
	@Column(name="TYPE_DESCRIPTION",length=100,nullable=false)
	private String type;



	/**
	 * Gets the idtypemovie.
	 *
	 * @return the idtypemovie
	 */
	public Long getIdtypemovie() {
		return idtypemovie;
	}



	/**
	 * Sets the idtypemovie.
	 *
	 * @param idtypemovie the new idtypemovie
	 */
	public void setIdtypemovie(Long idtypemovie) {
		this.idtypemovie = idtypemovie;
	}



	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}



	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TypeMovie [idtypemovie=" + idtypemovie + ", type=" + type + "]";
	}


}
