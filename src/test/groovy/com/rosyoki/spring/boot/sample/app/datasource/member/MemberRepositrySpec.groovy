package com.rosyoki.spring.boot.sample.app.datasource.member

import com.rosyoki.spring.boot.sample.app.domain.member.Id
import com.rosyoki.spring.boot.sample.app.domain.member.LoginName
import com.rosyoki.spring.boot.sample.app.domain.member.MemberRepositry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
class MemberRepositrySpec extends Specification {

    @Autowired
    private MemberRepositry memberRepositry

    @Unroll
    def "IDで検索 #id"() {
        setup:

        expect:
        actual == memberRepositry.getUsersById(new Id(id))

        where:
        id || actual
        1L|| FixtureMemberData.get()
        1000L|| Optional.empty()
    }

    @Unroll
    def "ログイン名で検索 #login_name"() {
        setup:

        expect:
        actual == memberRepositry.getUserByLoginName(new LoginName(login_name))

        where:
        login_name || actual
        "rosyoki"|| FixtureMemberData.get()
        "testaaa"|| Optional.empty()
    }

    @Unroll
    def "全件取得"() {
        setup:

        expect:
        0 < memberRepositry.getAllUsers().size()
    }
}
