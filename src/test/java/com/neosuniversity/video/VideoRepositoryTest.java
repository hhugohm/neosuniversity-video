package com.neosuniversity.video;

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


@SpringBootTest
@ExtendWith(SpringExtension.class)
class VideoRepositoryTest {

	@Autowired
	private MovieRepository movieRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testReadMovie() {
		Optional<Movie> movie = movieRepository.findById(3L);
		//assertThat(movie).isNotEmpty().containsInstanceOf(Season.class);

		if (movie.isPresent()) {
			System.out.println("####: " + movie);
		}

	}

}
