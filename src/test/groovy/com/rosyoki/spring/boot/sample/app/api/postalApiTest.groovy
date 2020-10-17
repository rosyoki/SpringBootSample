package com.rosyoki.spring.boot.sample.app.api

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class postalApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPostalDataByZipTest() {
        this.mockMvc.perform(get("/api/postal/zip/2420001"))
                .andExpect(status().isOk())
    }
}
