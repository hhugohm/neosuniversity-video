package com.neosuniversity.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosuniversity.video.entities.UserInformation;

public interface UserInformationRepository extends JpaRepository<UserInformation, String> {

}
