package com.rosyoki.spring.boot.sample.app.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosyoki.spring.boot.sample.app.users.entity.Users;

public interface PostAlRepository extends JpaRepository<Users, Long>{

}
