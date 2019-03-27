package com.rosyoki.spring.boot.sample.app.datasource

import com.ninja_squad.dbsetup.destination.DataSourceDestination
import com.rosyoki.spring.boot.sample.app.domain.City
import com.rosyoki.spring.boot.sample.app.domain.NewZip
import com.rosyoki.spring.boot.sample.app.domain.PostAlRepositry
import com.rosyoki.spring.boot.sample.app.domain.Postal
import com.rosyoki.spring.boot.sample.app.entity.PostZipData
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

@Unroll
@SpringBootTest
class PostAlDbSpec extends Specification {

    @Autowired
    DataSource dataSource

    @Autowired
    private PostAlRepositry postAlRepositry

    def "郵便番号で検索"() {
        setup:
        Postal postal = postAlRepositry.getPostDataByZip(new NewZip("2420007"))

        expect:
        postal == FixturePostData.get()
    }

    def "市名で検索"() {
        setup:
        List<Postal> postalList = postAlRepositry.getPostAlDataByCity(new City("大和市"))

        expect:
        postalList.size() == 26
        postalList.get(7) == FixturePostData.get()
    }
}
