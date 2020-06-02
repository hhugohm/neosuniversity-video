package com.neosuniversity.video.business;



import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.neosuniversity.video.entities.Movie;

public interface MovieBusinessI {
	
	
	Movie readMovieById(Long id);
	
	void createMovie(Movie movie);
	
	void updateMovie(Movie movie,Long id);
	
	void deleteMovie(Movie movie);
	
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

	default  boolean validateString(String value) {
		value = StringUtils.defaultString(value);
		if (StringUtils.isEmpty(value) && StringUtils.isBlank(value)) {
			return true;
		} else {
			return false;
		}

	}

	default boolean validateDate(Date date) {
		Optional<Date> dateOptional = Optional.ofNullable(date);
		if (dateOptional.isPresent()) {
			return true;
		} else {
			return false;
		}

	}

}
