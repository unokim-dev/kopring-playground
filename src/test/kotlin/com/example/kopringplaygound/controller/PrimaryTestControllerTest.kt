package com.example.kopringplaygound.controller

import com.example.kopringplaygound.config.PrimaryConfig
import com.example.kopringplaygound.config.PrimaryDefaultConfig
import com.example.kopringplaygound.config.SecurityConfig
import com.example.kopringplaygound.dto.request.PostBody
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@Import(SecurityConfig::class, PrimaryConfig::class, PrimaryDefaultConfig::class)
@WebMvcTest(PrimaryTestController::class)
class PrimaryTestControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper,
) {

    @Test
    fun test() {
        // Arrange

        // Act & Assert
        mockMvc.perform(get("/primary"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
    }

    @Test
    @WithMockUser
    fun postTest() {
        // Arrange
//        val request = objectMapper.writeValueAsString(PostBody(1L, "uno"))
        val str = "{\"id\":1,\"name\":\"uno\"}"

        // Act & Assert
        mockMvc.perform(
            post("/post-test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(str)
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
    }
}
