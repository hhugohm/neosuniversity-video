package com.neosuniversity.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosuniversity.video.entities.Authority;
import com.neosuniversity.video.entities.AuthorityId;

public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId> {

}
