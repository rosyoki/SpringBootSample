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
import org.springframework.web.bind.annotation.ModelAttribute;
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

    /**
     * ユーザリスト
     * 
     * @param model
     * @return
     */
    @RequestMapping("/users/userList")
    public String userList(Model model) {

        logger.debug(">>>>>>>> userList >>>>>>>>");
        List<Users> usersList = usersService.getAllUsersData();
        model.addAttribute("users", usersList);

        return "users/usersList";
    }

    /**
     * ユーザ登録トップ画面
     * 
     * @param usersForm
     * @param model
     * @return
     */
    @RequestMapping("/users/regist")
    public String registUser(UsersForm usersForm, Model model) {
        model.addAttribute(usersForm);
        
        return "users/registInput";
    }

    /**
     * ユーザ登録確認画面
     * 
     * @param usersForm
     * @param result
     * @param model
     * @return
     */
    @RequestMapping("/users/confirm")
    public String registUserConfirm(@Validated @ModelAttribute("usersForm") UsersForm usersForm,
            BindingResult result,Model model) {
        logger.info(">>>>>> start registUserConfirm >>>>>>>>>");
        // 入力エラーチェック
        if (result.hasErrors()) {
            logger.debug(">>> error >>>>");

            return registUser(usersForm, model);
        }

        // ユーザ存在チェック
        Users users = usersService.getUserByLoginName(usersForm.getLoginName());
        if (users != null) {
            return "users/registInput";
        }

        model.addAttribute("usersForm", usersForm);

        return "users/confirm";
    }

    /**
     * ユーザ登録処理
     * 
     * @param usersForm
     * @param result
     * @param model
     * @return
     */
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
