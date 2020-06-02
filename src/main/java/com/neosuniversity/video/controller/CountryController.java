package com.neosuniversity.video.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;


import com.neosuniversity.video.business.CountryBusinessI;
import com.neosuniversity.video.entities.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/neosuniversity/countries")
public class CountryController {
	
	
	@Autowired
	private CountryBusinessI countryBusinessI;
	
	@GetMapping(path="/{idCountry}", produces = "application/json")
	public ResponseEntity<Country> readCountryById(@PathVariable("idCountry") Long idCountry) {
		
		return ResponseEntity.ok()
				.header("idCountry",String.valueOf(idCountry))
				.body(countryBusinessI.readCountryById(idCountry));
	}
	
	@PostMapping(consumes = "application/json",produces = "application/json")
	public ResponseEntity<Country> createCountry(@Valid @RequestBody Country country) {
		
		log.info(country.toString());
		
		countryBusinessI.createCountry(country);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(country.getIdcountry())
                                    .toUri();
        return ResponseEntity.created(location).body(country);
	}

	
	@PutMapping(consumes = "application/json",produces = "application/json")
	public ResponseEntity<Country> updateCountry(@Valid @RequestBody Country country) {
		
		log.info(country.toString());
		
		countryBusinessI.updateCountry(country);
       
		return ResponseEntity.ok()
		.header("idCountry",String.valueOf(country.getIdcountry()))
		.body(countryBusinessI.readCountryById(country.getIdcountry()));
	}
	
	@DeleteMapping(path="/{idCountry}",produces = "application/json")
	public ResponseEntity<?> deleteCountry(@PathVariable("idCountry") Long idCountry) {
		
		Country country = countryBusinessI.readCountryById(idCountry);
		
		countryBusinessI.deleteCountry(country);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(country.getIdcountry())
                .toUri();
       
		return ResponseEntity.ok().location(location).build();
	}
	
	//java.util.NoSuchElementException: No value present] with root cause
}
