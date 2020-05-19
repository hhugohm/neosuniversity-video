package com.neosuniversity.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosuniversity.video.entities.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String> {

}
