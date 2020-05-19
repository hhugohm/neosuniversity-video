package com.neosuniversity.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosuniversity.video.entities.Season;

public interface SeasonRepository extends JpaRepository<Season, Long> {

}
