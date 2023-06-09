package com.example.kopringplaygound.service

import com.fasterxml.jackson.core.JacksonException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SampleServiceTest(
    @Autowired private val sut: SampleService,
) {
    @Test
    fun jacksonTest() {
        val result: JacksonException = Assertions.catchThrowable { sut.jackson("""{"name": "Uno", "cake": "asdf"}""") } as JacksonException
        println(result.location)
        println(result.location.contentReference())
        println(result.location.offsetDescription())
        println(result.location.sourceDescription())
    }
}