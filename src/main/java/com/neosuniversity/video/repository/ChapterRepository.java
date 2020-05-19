package com.neosuniversity.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosuniversity.video.entities.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

}
