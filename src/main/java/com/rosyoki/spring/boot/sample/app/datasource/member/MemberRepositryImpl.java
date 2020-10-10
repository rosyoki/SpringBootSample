package com.rosyoki.spring.boot.sample.app.datasource.member;

import com.rosyoki.spring.boot.sample.app.domain.member.Id;
import com.rosyoki.spring.boot.sample.app.domain.member.LoginName;
import com.rosyoki.spring.boot.sample.app.domain.member.Member;
import com.rosyoki.spring.boot.sample.app.domain.member.MemberRepositry;
import com.rosyoki.spring.boot.sample.app.domain.member.Passwd;
import com.rosyoki.spring.boot.sample.app.entity.Users;
import com.rosyoki.spring.boot.sample.app.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemberRepositryImpl implements MemberRepositry {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Optional<Member> getUsersById(Id id) {
        Users users = usersMapper.selectByPrimaryKey(id.getValue());

        if(users != null) {
            return Optional.of(
                    generateMember(users)
            );
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Member> getUserByLoginName(LoginName loginName) {
        Users users = usersMapper.selectByLoginName(loginName.getValue());
        if(users == null) {
            return Optional.empty();
        }
        return Optional.of(
                generateMember(users)
        );
    }

    @Override
    public List<Member> getAllUsers() {
        List<Users> usersList = usersMapper.selectAll();

        return usersList.stream()
                .map(this::generateMember)
                .collect(Collectors.toList());
    }

    private Member generateMember(Users users) {
        return new Member(
                new Id(users.getId()),
                new LoginName(users.getLoginName()),
                new Passwd(users.getPasswd())
        );
    }
}
