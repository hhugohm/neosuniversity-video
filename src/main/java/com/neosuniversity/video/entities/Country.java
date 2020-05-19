package com.neosuniversity.video.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;



/**
 * 
 * @author hhugohm
 * 
 *         COUNTRY Entity that store information <br>
 *         related  catalog country
 *
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="COUNTRY",schema="VIDEODB")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COUNTRY",nullable=false,unique=false)
	@Getter
	@Setter
	private Long idcountry;
	
	@NonNull
	@Column(name="COUNTRY",length=100,nullable=false)
	private String description;

}
