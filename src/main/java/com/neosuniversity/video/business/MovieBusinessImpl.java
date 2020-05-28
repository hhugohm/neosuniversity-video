package com.neosuniversity.video.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosuniversity.video.entities.Movie;
import com.neosuniversity.video.repository.MovieRepository;

@Service
public class MovieBusinessImpl implements MovieBusinessI {
	
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie readMovieById(Long id) {
	
		return movieRepository.findById(id).get();
	}

	@Override
	public void createMovie(Movie movie) {
		movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}

}
