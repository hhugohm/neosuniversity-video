package com.neosuniversity.video.controller;

import java.net.URI;

import javax.validation.Valid;

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

import com.neosuniversity.video.business.MovieBusinessI;
import com.neosuniversity.video.entities.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/neosuniversity/movies")
public class MovieController {

	@Autowired
	private MovieBusinessI movieBusinessI;
	
	@GetMapping(path="/{idMovie}", produces = "application/json")
	public ResponseEntity<Movie> readCountryById(@PathVariable("idMovie") Long idMovie) {
		
		return ResponseEntity.ok()
				.header("idMovie",String.valueOf(idMovie))
				.body(movieBusinessI.readMovieById(idMovie));
	}
	
	@PostMapping(consumes = "application/json",produces = "application/json")
	public ResponseEntity<Void> createCountry(@Valid @RequestBody Movie movie) {
		
		log.info(movie.toString());
		
		movieBusinessI.createMovie(movie);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(movie.getIdmovie())
                                    .toUri();
        return ResponseEntity.created(location).build();
	}
	@PutMapping(path="/{idMovie}",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Void> updateCountry(@Valid @RequestBody Movie movie,@PathVariable("idMovie") Long idMovie) {
		
		log.info(movie.toString());
		movieBusinessI.updateMovie(movie, idMovie);
		
		return ResponseEntity.ok().build();
		
	}
	@DeleteMapping(path="/{idMovie}",produces = "application/json")
	public ResponseEntity<Void> deleteCountry(@PathVariable("idMovie") Long idMovie) {
		
		Movie movie = movieBusinessI.readMovieById(idMovie);
		
		movieBusinessI.deleteMovie(movie);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(idMovie)
                .toUri();
       
		return ResponseEntity.ok().location(location).build();
	}
}
