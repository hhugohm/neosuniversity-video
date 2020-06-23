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
package com.neosuniversity.video.business;



import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.neosuniversity.video.entities.Movie;

/**
 * The Interface MovieBusinessI.
 * @author Neosuniversity
 * @version 1.0 
 * 
 */
public interface MovieBusinessI {
	
	
	/**
	 * Read movie by id.
	 *
	 * @param id the id
	 * @return the movie
	 */
	Movie readMovieById(Long id);
	
	/**
	 * Creates the movie.
	 *
	 * @param movie the movie
	 */
	void createMovie(Movie movie);
	
	/**
	 * Update movie.
	 *
	 * @param movie the movie
	 * @param id    the id
	 */
	void updateMovie(Movie movie,Long id);
	
	/**
	 * Delete movie.
	 *
	 * @param movie the movie
	 */
	void deleteMovie(Movie movie);
	
	/**
	 * Validate movie data.
	 *
	 * @param movie   the movie
	 * @param movieDB the movie DB
	 */
	default void validateMovieData(Movie movie, Movie movieDB) {
		if (!validateString(movie.getTitle())) {
			movieDB.setTitle(movie.getTitle());
		}
		if (!validateString(movie.getImagepath())) {
			movieDB.setImagepath(movie.getImagepath());
		}
		if (!validateString(movie.getSynopsis())) {
			movieDB.setSynopsis(movie.getSynopsis());
		}
		if (validateDate(movie.getDuration())) {
			movieDB.setDuration(movie.getDuration());
		}
	}

	/**
	 * Validate string.
	 *
	 * @param value the value
	 * @return true, if successful
	 */
	default  boolean validateString(String value) {
		value = StringUtils.defaultString(value);
		if (StringUtils.isEmpty(value) && StringUtils.isBlank(value)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Validate date.
	 *
	 * @param date the date
	 * @return true, if successful
	 */
	default boolean validateDate(Date date) {
		Optional<Date> dateOptional = Optional.ofNullable(date);
		if (dateOptional.isPresent()) {
			return true;
		} else {
			return false;
		}

	}

}
