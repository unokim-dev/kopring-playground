package com.example.kopringplaygound.controller

import com.example.kopringplaygound.config.PrimaryConfig
import com.example.kopringplaygound.config.PrimaryDefaultConfig
import com.example.kopringplaygound.config.SecurityConfig
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@Import(SecurityConfig::class, PrimaryConfig::class, PrimaryDefaultConfig::class)
@WebMvcTest(PrimaryTestController::class)
class PrimaryTestControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
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
}