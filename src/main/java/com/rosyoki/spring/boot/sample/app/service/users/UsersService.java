/**
 *
 */
package com.rosyoki.spring.boot.sample.app.service.users;

import com.rosyoki.spring.boot.sample.app.domain.member.LoginName;
import com.rosyoki.spring.boot.sample.app.domain.member.Member;
import com.rosyoki.spring.boot.sample.app.domain.member.MemberRepositry;
import com.rosyoki.spring.boot.sample.app.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author hirofumi_tsutsui
 */

@Service
public class UsersService {

    @Autowired
    MemberRepositry memberRepositry;

    /**
     * 全てのユーザデータを取得する。
     *
     * @return
     */
    public List<Users> getAllUsersData() {
        return null;
    }

    /**
     * 指定されたIDのユーザを取得する。
     *
     * @param id
     * @return
     */
    public Optional<Users> getUsersById(Long id) {
        return Optional.empty();
    }

    /**
     * 新規ユーザの登録を行う。
     *
     * @param users
     */
    @Transactional
    public void registerUser(Users users) {

    }

    /**
     * ログイン名からユーザ情報を取得する。
     *
     * @param loginName
     * @return
     */
    public Member getUserByLoginName(LoginName loginName) {
        return memberRepositry.getUserByLoginName(loginName).orElseThrow();
    }
}
