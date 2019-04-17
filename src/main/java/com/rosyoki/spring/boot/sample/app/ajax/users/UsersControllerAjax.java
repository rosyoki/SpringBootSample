/**
 *
 */
package com.rosyoki.spring.boot.sample.app.ajax.users;

import com.rosyoki.spring.boot.sample.app.domain.exception.NotFoundException;
import com.rosyoki.spring.boot.sample.app.entity.Users;
import com.rosyoki.spring.boot.sample.app.service.users.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author hirofumi_tsutsui
 */
@RestController
@Slf4j
public class UsersControllerAjax {

    @Autowired
    UsersService usersService;

    @CrossOrigin(origins = {"http://localhost", "http://server1.rosyoki.com"})
    @RequestMapping(value = "/ajax/users", method = RequestMethod.GET, produces = "application/json")
    public HashMap<String, List<Users>> getUsersList() {
        log.info(">>>>> start getUsersList >>>>>");

        List<Users> usersList = usersService.getAllUsersData();
        HashMap<String, List<Users>> data = new HashMap<String, List<Users>>();
        data.put("records", usersList);

        //usersJooqService.getAllUsersData();

        log.info(">>>>> end getUsersList >>>>>");

        return data;
    }

    @CrossOrigin(origins = {"http://localhost", "http://server1.rosyoki.com"})
    @RequestMapping(value = "/ajax/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Users> getUsers(@PathVariable Long id) {
        log.info(">>>>> start getUsers >>>>>");

        Optional<Users> users = usersService.getUsersById(id);

        return new ResponseEntity<Users>(users.orElseThrow(
                () -> new NotFoundException(id + ":会員が見つかりませんでした。")
        ), HttpStatus.OK);
    }
}
