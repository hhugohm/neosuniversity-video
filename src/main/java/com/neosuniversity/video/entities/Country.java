package com.neosuniversity.video.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Tolerate;




/**
 * 
 * @author hhugohm
 * 
 *         COUNTRY Entity that store information <br>
 *         related  catalog country
 *
 */

@Data
@Builder
@Entity
@Table(name="COUNTRY",schema="VIDEODB")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COUNTRY",nullable=false,unique=true)
	@JsonProperty("keyCountry")
	private Long idcountry;
	
	
	//@NonNull
	@Column(name="COUNTRY",length=100,nullable=false)
	@JsonProperty("country")
	private String description;
	
	@Tolerate
	public Country() {
		
	}

}
