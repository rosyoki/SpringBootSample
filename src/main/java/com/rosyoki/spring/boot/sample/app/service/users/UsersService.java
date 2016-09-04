/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.service.users;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosyoki.spring.boot.sample.app.entity.Users;
import com.rosyoki.spring.boot.sample.app.mapper.UsersMapper;

/**
 * @author hirofumi_tsutsui
 *
 */

@Service
@Transactional
public class UsersService {
    
    @Autowired
    UsersMapper usersMapper;

    /**
     * 
     * @return
     */
    public List<Users> getAllUsersData() {
        return usersMapper.selectByExample(null);
    }
    
    public Users getUsersById(Long id) {
        return null;
    }
    
    public void registUser(Users users) {
        usersMapper.insert(users);
    }
    
    public Users getUserByLoginName(String loginName) {
        return usersMapper.selectByExample(null).get(0);
    }
}
