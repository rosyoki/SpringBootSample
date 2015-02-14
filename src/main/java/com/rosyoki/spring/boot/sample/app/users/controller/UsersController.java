/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.users.controller;


import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
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

    @RequestMapping("/users/")
    public String index(Model model) {
        return userList(model);
    }

    @RequestMapping("/users/userList")
    public String userList(Model model) {

        logger.debug(">>>>>>>> userList >>>>>>>>");
        List<Users> usersList = usersService.getAllUsersData();
        model.addAttribute("users", usersList);

        return "users/usersList";
    }

    @RequestMapping("/users/regist")
    public String registUser(Model model) {
        return "users/registInput";
    }

    @RequestMapping("/users/confirm")
    public String registUserConfirm(@Validated UsersForm usersForm,
            BindingResult result, Model model) {
        logger.info(">>>>>> start registUserConfirm >>>>>>>>>");
        // 入力エラーチェック
        if (result.hasErrors()) {
            logger.debug(">>> error >>>>");

            return registUser(model);
        }

        // ユーザ存在チェック
        Users users = usersService.getUserByLoginName(usersForm.getLoginName());
        if (users != null) {
            return "users/registInput";
        }

        model.addAttribute("usersForm", usersForm);

        return "users/confirm";
    }

    @RequestMapping("/users/commit")
    public String registUserCommit(@Validated UsersForm usersForm,
            BindingResult result, Model model) {
        logger.info(">>>>>> start registUserCommit >>>>>>>>>");

        // パラメーターチェック
        if (result.hasErrors()) {
            logger.debug(">>> error >>>>");
            return "users/registInput";
        }

        // データ登録
        Users users = new Users();
        BeanUtils.copyProperties(usersForm, users);
        usersService.registUser(users);

        return "users/commit";
    }
}
