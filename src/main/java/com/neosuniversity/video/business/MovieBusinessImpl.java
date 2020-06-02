package com.neosuniversity.video.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosuniversity.video.entities.Movie;
import com.neosuniversity.video.errors.MovieNotFoundException;
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

	@Override
	public void updateMovie(Movie movie, Long id) {
		movieRepository.findById(id).map(movieDB -> {
			validateMovieData(movie, movieDB);
			return movieRepository.save(movieDB);
		}).orElseThrow(() -> new MovieNotFoundException(id));
	}

}
