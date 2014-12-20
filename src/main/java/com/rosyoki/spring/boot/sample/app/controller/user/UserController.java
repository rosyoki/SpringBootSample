/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hirofumi_tsutsui
 *
 */
@Controller
public class UserController {
    
    @RequestMapping("/user/userList")
    @ResponseBody
    public String userList() {
        return "userList";
    }
}
