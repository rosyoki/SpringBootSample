/**
 *
 */
package com.rosyoki.spring.boot.sample.app.api.users;

import com.rosyoki.spring.boot.sample.app.domain.exception.NotFoundException;
import com.rosyoki.spring.boot.sample.app.domain.member.LoginName;
import com.rosyoki.spring.boot.sample.app.domain.member.Member;
import com.rosyoki.spring.boot.sample.app.entity.Users;
import com.rosyoki.spring.boot.sample.app.form.users.UsersForm;
import com.rosyoki.spring.boot.sample.app.service.users.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author hirofumi_tsutsui
 */
@RestController
@Slf4j
public class UsersApi {

    @Autowired
    UsersService usersService;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @CrossOrigin
    @RequestMapping(value = "/api/users/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getUsersTest() {
        log.info(">>>>> start getUsersTest >>>>>");

        return new ResponseEntity<String>(
                "test",
                HttpStatus.OK
        );
    }

    @CrossOrigin(origins = "http://localhost:8081", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    @RequestMapping(value = "/api/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Member>> getUsersList() {
        log.info(">>>>> start getUsersList >>>>>");

        return new ResponseEntity<List<Member>>(
                usersService.getAllUsersData(),
                HttpStatus.OK
        );
    }

    @CrossOrigin(origins = {"http://localhost:8081", "http://server1.rosyoki.com"})
    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Users> getUsers(@PathVariable Long id) {
        log.info(">>>>> start getUsers >>>>>");

        return new ResponseEntity<Users>(
                Optional.ofNullable(usersService.getUsersById(id))
                        .orElseThrow(
                                () -> new NotFoundException(id + ":会員が見つかりませんでした。")),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/api/users/passwd/{loginName}", method = RequestMethod.GET)
    public ResponseEntity<String> getPassword(@PathVariable String loginName) {
        log.info(">>>>> start getPassword >>>>>");

        String passwd = Optional.ofNullable(
                usersService.getUserByLoginName(new LoginName(loginName))
        ).orElseThrow(
                () -> new NotFoundException(loginName + ":会員が見つかりませんでした。")
        ).passwd.getValue();

//        log.debug(passwd + " >>>>>> " + passwordEncoder.encode(passwd));
        return new ResponseEntity<String>(
                Optional.ofNullable(passwd)
                        .orElseThrow(
                                () -> new NotFoundException(loginName + ":パスワードが設定されていません。")),
                HttpStatus.OK
        );
    }

    @CrossOrigin(origins = {"http://localhost:8081", "http://server1.rosyoki.com"})
    @RequestMapping(value = "/api/user/regist", method = RequestMethod.POST)
    public ResponseEntity<String> registUser(@RequestBody UsersForm usersForm) {
        log.debug(">>>>>>> " + usersForm.getLoginName());
        log.debug(">>>>>>>> " + usersForm.getPasswd());
        return new ResponseEntity<String>("OK",HttpStatus.CREATED);
    }
}
