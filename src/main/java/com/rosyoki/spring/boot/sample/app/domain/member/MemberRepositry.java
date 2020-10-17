package com.rosyoki.spring.boot.sample.app.domain.member;

import java.util.List;

public interface MemberRepositry {
    Member getUsersById(Id id);
    Member getUserByLoginName(LoginName loginName);
    List<Member> getAllUsers();
}
