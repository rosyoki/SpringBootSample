package com.rosyoki.spring.boot.sample.app.service.postal

import com.rosyoki.spring.boot.sample.app.datasource.postal.FixturePostData
import com.rosyoki.spring.boot.sample.app.domain.postal.NewZip
import com.rosyoki.spring.boot.sample.app.domain.postal.PostAlRepositry
import com.rosyoki.spring.boot.sample.app.domain.postal.Postal
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification
import spock.lang.Unroll

@RunWith(SpringRunner.class)
@Unroll
@SpringBootTest
class PostalServiceSpec extends Specification {

    @MockBean
    private PostAlRepositry postAlRepositry;

    @Autowired
    private PostAlService postAlService;

    @Test
    public void "郵便番号で検索"() {
        Mockito.when(
                postAlRepositry.getPostDataByZip(new NewZip("2420001"))
        ).thenReturn(FixturePostData.get(1))

        Postal postal = postAlService.getPostDataByZip(new NewZip("2420001"));

        Assert.assertEquals(FixturePostData.get(1), postal)
    }
}
