/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.users.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rosyoki.spring.boot.sample.app.users.entity.Users;
import com.rosyoki.spring.boot.sample.app.users.service.UsersService;

/**
 * @author hirofumi_tsutsui
 *
 */
@Controller
public class UsersController {

    @Autowired
    UsersService usersService;

    private Logger logger = Logger.getLogger(UsersController.class);

    @RequestMapping("/user/userList")
    public String userList() {
        List<Users> usersList = usersService.findAll();
        logger.info(">>>>> " + usersList.size());

        return "users/usersList";
    }

    @RequestMapping("/users/regist")
    public String registUser() {

        return "users/registUsers";
    }
}
