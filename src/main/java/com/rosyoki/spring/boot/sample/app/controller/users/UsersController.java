/**
 *
 */
package com.rosyoki.spring.boot.sample.app.controller.users;


import com.rosyoki.spring.boot.sample.app.domain.member.Id;
import com.rosyoki.spring.boot.sample.app.domain.member.LoginName;
import com.rosyoki.spring.boot.sample.app.domain.member.Member;
import com.rosyoki.spring.boot.sample.app.entity.Users;
import com.rosyoki.spring.boot.sample.app.form.users.UsersForm;
import com.rosyoki.spring.boot.sample.app.service.users.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author hirofumi_tsutsui
 */
@Controller
@Slf4j
public class UsersController {

    @Autowired
    UsersService usersService;

    //@Autowired
    //UsersJooqService usersJooqService;

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

        log.debug(">>>>>>>> userList start >>>>>>>>");
        List<Member> usersList = usersService.getAllUsersData();
        model.addAttribute("users", usersList);

        return "users/usersList";
    }

    /**
     * @param usersForm
     * @param model
     * @return
     */
    @RequestMapping("/users/edit/{id}")
    public String editUser(UsersForm usersForm, Model model) {
        log.info(">>>>>> start editUser >>>>>>>>>");

        Member member = null;
        if (usersForm.getId() != null) {
            member = usersService.getUsersById(new Id(usersForm.getId()));
        }

        return "users/editInput";
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
                                    BindingResult result, Model model) {
        log.info(">>>>>> start registUserConfirm >>>>>>>>>");
        // 入力エラーチェック
        if (result.hasErrors()) {

            return registUser(usersForm, model);
        }

        // ユーザ存在チェック
        Member member = usersService.getUserByLoginName(new LoginName(usersForm.getLoginName()));
        if (member != null) {
            return registUser(usersForm, model);
        }

        model.addAttribute("usersForm", usersForm);

        return "users/confirm";
    }

    @RequestMapping("/users/editconfirm")
    public String editUserConfirm(@Validated @ModelAttribute("usersForm") UsersForm usersForm,
                                  BindingResult result, Model model) {
        log.info(">>>>>> start editUserConfirm >>>>>>>>>");
        // 入力エラーチェック
        if (result.hasErrors()) {

            return "users/editInput/" + usersForm.getId();
        }

        // 会員存在チェック
        Member member = usersService.getUserByLoginName(new LoginName(usersForm.getLoginName()));
        if (member == null) {
            return "users/usersList";
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
        log.info(">>>>>> start registUserCommit >>>>>>>>>");

        // パラメーターチェック
        if (result.hasErrors()) {
            return "users/registInput";
        }

        // データ登録
        Users users = new Users();
        BeanUtils.copyProperties(usersForm, users);

        //現在時刻取得
        users.setCreated(new Timestamp(System.currentTimeMillis()));

        //usersJooqService.registUser(users);

        return userList(model);
    }
}
