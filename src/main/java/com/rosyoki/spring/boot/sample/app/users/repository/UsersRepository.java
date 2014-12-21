/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rosyoki.spring.boot.sample.app.users.entity.Users;

/**
 * @author hirofumi_tsutsui
 *
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
