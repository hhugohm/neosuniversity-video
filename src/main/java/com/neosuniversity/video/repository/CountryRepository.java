package com.neosuniversity.video.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.neosuniversity.video.entities.Country;


/**
 * 
 * @author hhugohm
 * 
 * Country repository
 *
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
	
	List<Country> findByDescriptionContaining(String description); 
	
	Page<Country> findAll(Pageable pageable);

}
