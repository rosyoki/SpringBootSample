package com.rosyoki.spring.boot.sample.app.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rosyoki.spring.boot.sample.app.users.entity.PostZipData;

@Repository
public interface PostAlRepository extends JpaRepository<PostZipData, Long>{

}
