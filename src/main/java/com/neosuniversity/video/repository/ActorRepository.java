package com.neosuniversity.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosuniversity.video.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {

	
}
