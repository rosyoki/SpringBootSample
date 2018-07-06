/**
 *
 */
package com.rosyoki.spring.boot.sample.app.service.users;

import com.rosyoki.spring.boot.sample.app.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

import static com.rosyoki.spring.boot.sample.app.jooq.blog_db.tables.Users.USERS;

/**
 * @author hirofumi_tsutsui
 */

@Service
@Slf4j
public class UsersJooqService {

    @Autowired
    DSLContext dslContext;

    /**
     * 全てのユーザデータを取得する。
     *
     * @return
     */
    public List<Users> getAllUsersData() {
        Result<Record> result = dslContext.select().from(USERS).fetch();
        log.debug(">>>>>>>> " + result.size());
        return null;
    }

    /**
     * 指定されたIDのユーザを取得する。
     *
     * @param id
     * @return
     */
    public Users getUsersById(Long id) {
        Result<Record> result = dslContext.select()
                .from(com.rosyoki.spring.boot.sample.app.jooq.blog_db.tables.Users.USERS)
                .where(com.rosyoki.spring.boot.sample.app.jooq.blog_db.tables.Users.USERS.ID.eq(id))
                .getResult();
        return null;
    }

    /**
     * 新規ユーザの登録を行う。
     *
     * @param users
     */
    @Transactional
    public void registUser(Users users) {
        dslContext.insertInto(USERS,
                USERS.LOGIN_NAME, USERS.PASSWD, USERS.CREATED, USERS.MODIFIED)
                .values(users.getLoginName(),
                        users.getPasswd(),
                        new Timestamp(System.currentTimeMillis()),
                        new Timestamp(System.currentTimeMillis()))
                .execute();
    }

}
