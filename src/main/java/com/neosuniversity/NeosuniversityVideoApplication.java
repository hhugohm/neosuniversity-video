package com.neosuniversity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neosuniversity.video.entities.Movie;
import com.neosuniversity.video.repository.MovieRepository;

@SpringBootApplication
public class NeosuniversityVideoApplication implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(NeosuniversityVideoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		//testReadMovie();

	}

	public void testReadMovie() {
		Optional<Movie> movie = movieRepository.findById(3L);

		if (movie.isPresent()) {
			System.out.println(movie.toString());
		}
	}

}
