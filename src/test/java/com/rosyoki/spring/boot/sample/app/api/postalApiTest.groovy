package com.rosyoki.spring.boot.sample.app.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.rosyoki.spring.boot.sample.app.datasource.postal.FixturePostData
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class postalApiTest extends Specification {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Unroll
    def "getPostalDataByZipTest #zip"() {

        ObjectMapper mapper = new ObjectMapper();
        setup:

        expect:
        this.mockMvc.perform(get("/api/postal/zip/"+ zip))
                .andExpect(status().is(status))
                .andExpect(
                        content().string(
                                mapper.writeValueAsString(actual)
                        )
                )
        where:
        zip | status||actual
        "2420007"|200||FixturePostData.get()
        "2420001"|200||FixturePostData.get(1)
    }

    def "getPostalDataByZipTest_NOT_FOUND"() {
        ObjectMapper mapper = new ObjectMapper();
        setup:

        expect:
        this.mockMvc.perform(get("/api/postal/zip/"+ zip))
                .andExpect(status().is(status))
        where:
        zip || status
        "2422007"||404
    }
}
