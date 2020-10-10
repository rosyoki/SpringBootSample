package com.rosyoki.spring.boot.sample.app.domain.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepositry {
    Optional<Member> getUsersById(Id id);
    Optional<Member> getUserByLoginName(LoginName loginName);
    List<Member> getAllUsers();
}
