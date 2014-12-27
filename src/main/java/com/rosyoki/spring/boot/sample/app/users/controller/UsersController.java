/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.users.controller;

import java.util.List;

import javax.jws.WebParam.Mode;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rosyoki.spring.boot.sample.app.users.entity.Users;
import com.rosyoki.spring.boot.sample.app.users.form.UsersForm;
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

    @RequestMapping("/users/userList")
    public String userList(Model model) {
        
        logger.debug(">>>>>>>> userList >>>>>>>>");
        List<Users> usersList = usersService.getAllUsersData();
        model.addAttribute("users", usersList);
        
        return "users/usersList";
    }

    @RequestMapping("/users/regist")
    public String registUser(Model model) {
        //logger.debug(">>> " + usersService.checkExistLoginName("rosyoki"));
        logger.info(">>>> start registUser >>>>");
        return "users/registUsersInput";
    }
    
    @RequestMapping("/users/registConfirm")
    public String registUserConfirm(@Validated UsersForm usersForm, BindingResult result, Model model) {
        logger.info(">>>>>> start registUserConfirm >>>>>>>>>");
        if(result.hasErrors()) {
            logger.debug(">>> error >>>>");
            
            return "users/registUsersInput";
        }
        model.addAttribute("loginName", "test");
        
        return "users/registUsersConfirm";
    }
}
