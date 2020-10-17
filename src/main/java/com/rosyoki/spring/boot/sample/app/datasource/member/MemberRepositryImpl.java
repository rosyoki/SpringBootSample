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
import java.util.stream.Collectors;

@Repository
public class MemberRepositryImpl implements MemberRepositry {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Member getUsersById(Id id) {
        return generateMember(
                usersMapper.selectByPrimaryKey(id.getValue())
        );
    }

    @Override
    public Member getUserByLoginName(LoginName loginName) {
        return generateMember(
                usersMapper.selectByLoginName(loginName.getValue())
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
        if(users == null) {
            return null;
        }
        return new Member(
                new Id(users.getId()),
                new LoginName(users.getLoginName()),
                new Passwd(users.getPasswd())
        );
    }
}
