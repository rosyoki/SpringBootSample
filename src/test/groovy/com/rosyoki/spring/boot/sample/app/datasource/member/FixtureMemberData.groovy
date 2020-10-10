package com.rosyoki.spring.boot.sample.app.datasource.member

import com.rosyoki.spring.boot.sample.app.domain.member.Id
import com.rosyoki.spring.boot.sample.app.domain.member.LoginName
import com.rosyoki.spring.boot.sample.app.domain.member.Member
import com.rosyoki.spring.boot.sample.app.domain.member.Passwd

class FixtureMemberData {
    static Optional<Member> get(int n = 0) {
        [
                Optional.of(
                        new Member(
                                new Id(1),
                                new LoginName("rosyoki"),
                                new Passwd("password")
                        )
                )
        ].get(n)
    }
}
