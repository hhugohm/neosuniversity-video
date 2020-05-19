package com.neosuniversity.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosuniversity.video.entities.Movie;

public interface MovieRepository extends JpaRepository <Movie, Long> {
	
	

}
