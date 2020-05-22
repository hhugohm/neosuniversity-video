package com.neosuniversity.video.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;


import com.neosuniversity.video.business.CountryBusinessI;
import com.neosuniversity.video.entities.Country;

@RestController
@RequestMapping(path = "/api/neosuniversity/video")
public class CountryController {
	
	
	@Autowired
	private CountryBusinessI countryBusinessI;
	
	@GetMapping(path="/countries/{idCountry}", produces = "application/json")
	public ResponseEntity<Country> getCountryById(@PathVariable("idCountry") Long idCountry) {
		
		return ResponseEntity.ok()
				.header("idCountry",String.valueOf(idCountry))
				.body(countryBusinessI.getCountryById(idCountry));
	

	}

}
