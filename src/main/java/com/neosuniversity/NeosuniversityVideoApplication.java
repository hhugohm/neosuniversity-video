package com.neosuniversity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NeosuniversityVideoApplication { // implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NeosuniversityVideoApplication.class, args);
	}
	/*
	 * @Autowired private MovieRepository movieRepository;
	 * 
	 * 
	 * 
	 * public static void main(String[] args) {
	 * SpringApplication.run(NeosuniversityVideoApplication.class, args);
	 * 
	 * }
	 * 
	 * @Override public void run(String... args) throws Exception {
	 * //testReadMovie();
	 * 
	 * }
	 * 
	 * public void testReadMovie() { Optional<Movie> movie =
	 * movieRepository.findById(3L);
	 * 
	 * if (movie.isPresent()) { System.out.println(movie.toString()); } }
	 */
}
