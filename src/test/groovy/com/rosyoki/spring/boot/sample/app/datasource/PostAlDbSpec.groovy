package com.rosyoki.spring.boot.sample.app.datasource

import com.ninja_squad.dbsetup.destination.DataSourceDestination
import com.rosyoki.spring.boot.sample.app.domain.City
import com.rosyoki.spring.boot.sample.app.domain.NewZip
import com.rosyoki.spring.boot.sample.app.domain.PostAlRepositry
import com.rosyoki.spring.boot.sample.app.domain.Postal
import com.rosyoki.spring.boot.sample.app.entity.PostZipData
import org.hibernate.bytecode.enhance.spi.UnloadedClass
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.support.DirtiesContextTestExecutionListener
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import spock.lang.Shared
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
