package com.neosuniversity.video.entities;

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
 *         TYPE_MOVIE Entity that store information <br>
 *         related  type of Movies
 *
 */
@Entity
@Table(name="TYPE_MOVIE",schema="VIDEODB")
public class TypeMovie {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TYPE_MOVIE",nullable=false,unique=false)
	private Long idtypemovie;
	
	
	
	@Column(name="TYPE_DESCRIPTION",length=100,nullable=false)
	private String type;



	public Long getIdtypemovie() {
		return idtypemovie;
	}



	public void setIdtypemovie(Long idtypemovie) {
		this.idtypemovie = idtypemovie;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "TypeMovie [idtypemovie=" + idtypemovie + ", type=" + type + "]";
	}


}
