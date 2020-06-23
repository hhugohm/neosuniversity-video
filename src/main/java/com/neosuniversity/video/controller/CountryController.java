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

/** The  CountryController.
 * 
 * @author Neosuniversity
 * @version 1.0 
 */
@Slf4j
@RestController
@RequestMapping(path = "/api/v1/neosuniversity/countries")
public class CountryController {
	
	
	/** The country business I. */
	@Autowired
	private CountryBusinessI countryBusinessI;
	
	/**
	 * Read country by id.
	 *
	 * @param idCountry the id country
	 * @return the response entity
	 */
	@GetMapping(path="/{idCountry}", produces = "application/json")
	public ResponseEntity<Country> readCountryById(@PathVariable("idCountry") Long idCountry) {
		
		return ResponseEntity.ok()
				.header("idCountry",String.valueOf(idCountry))
				.body(countryBusinessI.readCountryById(idCountry));
	}
	
	/**
	 * Creates the country.
	 *
	 * @param country the country
	 * @return the response entity
	 */
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

	
	/**
	 * Update country.
	 *
	 * @param country the country
	 * @return the response entity
	 */
	@PutMapping(consumes = "application/json",produces = "application/json")
	public ResponseEntity<Country> updateCountry(@Valid @RequestBody Country country) {
		
		log.info(country.toString());
		
		countryBusinessI.updateCountry(country);
       
		return ResponseEntity.ok()
		.header("idCountry",String.valueOf(country.getIdcountry()))
		.body(countryBusinessI.readCountryById(country.getIdcountry()));
	}
	
	/**
	 * Delete country.
	 *
	 * @param idCountry the id country
	 * @return the response entity
	 */
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
