/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hirofumi_tsutsui
 *
 */
@Controller
public class UsersController {
    
    @RequestMapping("/user/userList")
    @ResponseBody
    public String userList() {
        return "userList";
    }
    
    @RequestMapping("/users/regist")
    public String registUser() {
        
        return "users/registUsers";
    }
}
