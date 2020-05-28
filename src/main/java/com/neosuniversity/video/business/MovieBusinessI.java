package com.neosuniversity.video.business;


import com.neosuniversity.video.entities.Movie;

public interface MovieBusinessI {
	
	
	Movie readMovieById(Long id);
	
	void createMovie(Movie movie);
	
	void deleteMovie(Movie movie);

}
