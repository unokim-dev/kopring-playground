package com.example.kopringplaygound.dto

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SealedClassTest @Autowired constructor(private val objectMapper: ObjectMapper) {

    @Test
    fun asdf() {
        val value = SealedClassEnvelop(SealedClass.Paying("sample-code"))
        println(objectMapper.writeValueAsString(value))
    }

    data class SealedClassEnvelop(val sealedClass: SealedClass? = null)
}