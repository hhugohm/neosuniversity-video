package com.neosuniversity.video.repository.test;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

import com.neosuniversity.video.entities.Movie;
import com.neosuniversity.video.entities.Season;
import com.neosuniversity.video.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class VideoRepositoryTest {

	@Autowired
	private MovieRepository movieRepository;

	
	@Test
	public void testReadMovie() {
		Optional<Movie> movie = movieRepository.findById(3L);
		
		log.info("¢¢¢¢¢¢¢¢¢¢   OKKKKKK" );
		//assertThat(movie).isNotEmpty().containsInstanceOf(Season.class);

		if (movie.isPresent()) {
			System.out.println("####: " + movie);
		}

	}

}
