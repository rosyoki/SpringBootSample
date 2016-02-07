/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.users.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rosyoki.spring.boot.sample.app.users.entity.Users;
import com.rosyoki.spring.boot.sample.app.users.service.UsersService;

/**
 * @author hirofumi_tsutsui
 *
 */
@RestController
@RequestMapping("ajax/users")
public class UsersControllerAjax {
    
    @Autowired
    UsersService usersService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Users> getUsersList() {
        List<Users> usersList = usersService.getAllUsersData();

        return usersList;
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public Users getUsers(@PathVariable Integer id) {
        Users users = usersService.getUsersById(id);
        return users;
    }
}
