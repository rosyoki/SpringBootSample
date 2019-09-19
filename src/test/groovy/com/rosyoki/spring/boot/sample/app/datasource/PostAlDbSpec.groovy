package com.rosyoki.spring.boot.sample.app.datasource

import com.rosyoki.spring.boot.sample.app.domain.City
import com.rosyoki.spring.boot.sample.app.domain.NewZip
import com.rosyoki.spring.boot.sample.app.domain.PostAlRepositry
import com.rosyoki.spring.boot.sample.app.domain.Postal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

import javax.sql.DataSource

@SpringBootTest
class PostAlDbSpec extends Specification {

    @Autowired
    DataSource dataSource

    @Autowired
    private PostAlRepositry postAlRepositry

    @Unroll
    def "郵便番号で検索 #zip"() {
        setup:

        expect:
        actual == postAlRepositry.getPostDataByZip(new NewZip(zip))

        where:
        zip || actual
        "2420007"||FixturePostData.get()
        "2420001"||FixturePostData.get(1)
        "2420010"||Optional.empty()
    }

    @Unroll
    def "市名で検索 #city"() {
        setup:
        List<Postal> postalList = postAlRepositry.getPostAlDataByCity(new City(city))

        expect:
        size == postalList.size()

        where:
        city||size
        "大和市"||26
        "神戸市中央区"||79
        "相模原市"||0
    }
}
