package com.neosuniversity.video.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;




/**
 * 
 * @author hhugohm
 * 
 *         COUNTRY Entity that store information <br>
 *         related  catalog country
 *
 */



@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="COUNTRY",schema="VIDEODB")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COUNTRY",nullable=false,unique=true)
	private Long idcountry;
	
	
	@NonNull
	@Column(name="COUNTRY",length=100,nullable=false)
	private String description;

}
