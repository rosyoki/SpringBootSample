/**
 *
 */
package com.rosyoki.spring.boot.sample.app.service.users;

import com.rosyoki.spring.boot.sample.app.entity.Users;
import com.rosyoki.spring.boot.sample.app.entity.UsersExample;
import com.rosyoki.spring.boot.sample.app.mapper.UsersMapper;
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
    UsersMapper usersMapper;

    /**
     * 全てのユーザデータを取得する。
     *
     * @return
     */
    public List<Users> getAllUsersData() {
        return usersMapper.selectByExample(null);
    }

    /**
     * 指定されたIDのユーザを取得する。
     *
     * @param id
     * @return
     */
    public Optional<Users> getUsersById(Long id) {
        return Optional.of(usersMapper.selectByPrimaryKey(id));
    }

    /**
     * 新規ユーザの登録を行う。
     *
     * @param users
     */
    @Transactional
    public void registUser(Users users) {
        usersMapper.insert(users);
    }

    /**
     * ログイン名からユーザ情報を取得する。
     *
     * @param loginName
     * @return
     */
    public Users getUserByLoginName(String loginName) {
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andLoginNameEqualTo(loginName);

        if (usersMapper.selectByExample(usersExample) == null) {
            return null;
        } else {
            if (usersMapper.selectByExample(usersExample).size() == 0) {
                return null;
            }
        }

        return usersMapper.selectByExample(usersExample).get(0);
    }
}
