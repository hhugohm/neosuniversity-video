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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosuniversity.video.entities.Movie;
import com.neosuniversity.video.errors.MovieNotFoundException;
import com.neosuniversity.video.repository.MovieRepository;

/**
 * The Class MovieBusinessImpl.
 * 
 * @author Neosuniversity
 * @version 1.0
 */
@Service
public class MovieBusinessImpl implements MovieBusinessI {

	/** The movie repository. */
	@Autowired
	private MovieRepository movieRepository;

	/* (non-Javadoc)
	 * @see com.neosuniversity.video.business.MovieBusinessI#readMovieById(java.lang.Long)
	 */
	@Override
	public Movie readMovieById(Long id) {

		return movieRepository.findById(id).get();
	}

	/* (non-Javadoc)
	 * @see com.neosuniversity.video.business.MovieBusinessI#createMovie(com.neosuniversity.video.entities.Movie)
	 */
	@Override
	public void createMovie(Movie movie) {
		movieRepository.save(movie);
	}

	/* (non-Javadoc)
	 * @see com.neosuniversity.video.business.MovieBusinessI#deleteMovie(com.neosuniversity.video.entities.Movie)
	 */
	@Override
	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}

	/* (non-Javadoc)
	 * @see com.neosuniversity.video.business.MovieBusinessI#updateMovie(com.neosuniversity.video.entities.Movie, java.lang.Long)
	 */
	@Override
	public void updateMovie(Movie movie, Long id) {
		movieRepository.findById(id).map(movieDB -> {
			validateMovieData(movie, movieDB);
			return movieRepository.save(movieDB);
		}).orElseThrow(() -> new MovieNotFoundException(id));
	}

}
