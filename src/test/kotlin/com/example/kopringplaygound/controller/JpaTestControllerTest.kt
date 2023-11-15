package com.example.kopringplaygound.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@SpringBootTest
class JpaTestControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
) {

    @Test
    fun `jpa 오류를 컨트롤러에서 보는 테스트`() {
        // Arrange

        // Act & Assert
        mockMvc.perform(post("/jpa/exception-test"))
            .andDo(print())
            .andExpect(status().isOk)
    }
}