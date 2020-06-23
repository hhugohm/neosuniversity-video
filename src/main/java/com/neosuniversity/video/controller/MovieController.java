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

/** The  MovieController.
 * 
 * @author Neosuniversity
 * @version 1.0 
 */
@Slf4j
@RestController
@RequestMapping(path = "/api/v1/neosuniversity/movies")
public class MovieController {

	/** The movie business I. */
	@Autowired
	private MovieBusinessI movieBusinessI;
	
	/**
	 * Read country by id.
	 *
	 * @param idMovie the id movie
	 * @return the response entity
	 */
	@GetMapping(path="/{idMovie}", produces = "application/json")
	public ResponseEntity<Movie> readCountryById(@PathVariable("idMovie") Long idMovie) {
		
		return ResponseEntity.ok()
				.header("idMovie",String.valueOf(idMovie))
				.body(movieBusinessI.readMovieById(idMovie));
	}
	
	/**
	 * Creates the country.
	 *
	 * @param movie the movie
	 * @return the response entity
	 */
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
	
	/**
	 * Update country.
	 *
	 * @param movie   the movie
	 * @param idMovie the id movie
	 * @return the response entity
	 */
	@PutMapping(path="/{idMovie}",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Void> updateCountry(@Valid @RequestBody Movie movie,@PathVariable("idMovie") Long idMovie) {
		
		log.info(movie.toString());
		movieBusinessI.updateMovie(movie, idMovie);
		
		return ResponseEntity.ok().build();
		
	}
	
	/**
	 * Delete country.
	 *
	 * @param idMovie the id movie
	 * @return the response entity
	 */
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
