/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.users.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rosyoki.spring.boot.sample.app.users.entity.Users;
import com.rosyoki.spring.boot.sample.app.users.repository.UsersRepository;

/**
 * @author hirofumi_tsutsui
 *
 */

@Service
@Transactional
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<Users> findAll() {
        return usersRepository.findAll();
    }
}
