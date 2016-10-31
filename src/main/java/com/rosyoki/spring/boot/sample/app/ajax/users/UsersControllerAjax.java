/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.ajax.users;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rosyoki.spring.boot.sample.app.entity.Users;
import com.rosyoki.spring.boot.sample.app.service.users.UsersService;

/**
 * @author hirofumi_tsutsui
 *
 */
@RestController
public class UsersControllerAjax {
    
    @Autowired
    UsersService usersService;
    private Logger logger = Logger.getLogger(UsersControllerAjax.class);
    
    @CrossOrigin(origins={"http://localhost","http://server1.rosyoki.com"})
    @RequestMapping(value="/ajax/users", method = RequestMethod.POST,produces = "application/json")
    public HashMap<String, List<Users>> getUsersList() {
        logger.info(">>>>> start getUsersList >>>>>");
        
        List<Users> usersList = usersService.getAllUsersData();
        HashMap<String, List<Users>> data = new HashMap<String, List<Users>>();
        data.put("records", usersList);

        logger.info(">>>>> end getUsersList >>>>>");
        
        return data;
    }

    @CrossOrigin(origins={"http://localhost","http://server1.rosyoki.com"})
    @RequestMapping(value="/ajax/users/{id}", method = RequestMethod.GET)
    public Users getUsers(@PathVariable Long id) {
        logger.info(">>>>> start getUsers >>>>>");
        
        Users users = usersService.getUsersById(id);
        
        return users;
    }
}
