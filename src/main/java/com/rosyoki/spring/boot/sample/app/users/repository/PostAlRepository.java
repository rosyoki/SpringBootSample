package com.rosyoki.spring.boot.sample.app.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rosyoki.spring.boot.sample.app.users.entity.PostZipData;

public interface PostAlRepository extends JpaRepository<PostZipData, Long>{

}
