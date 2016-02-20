/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.users.ajax;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rosyoki.spring.boot.sample.app.users.controller.UsersController;
import com.rosyoki.spring.boot.sample.app.users.entity.Users;
import com.rosyoki.spring.boot.sample.app.users.service.UsersService;

/**
 * @author hirofumi_tsutsui
 *
 */
@RestController
public class UsersControllerAjax {
    
    @Autowired
    UsersService usersService;
    private Logger logger = Logger.getLogger(UsersControllerAjax.class);
    
    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value="/ajax/users", method = RequestMethod.GET,produces = "application/json")
    public List<Users> getUsersList() {
        logger.info(">>>>> start getUsersList >>>>>");
        
        List<Users> usersList = usersService.getAllUsersData();

        return usersList;
    }

    @RequestMapping(value="/ajax/users/{id}", method = RequestMethod.GET)
    public Users getUsers(@PathVariable Integer id) {

        Users users = usersService.getUsersById(id);
        
        return users;
    }
}
