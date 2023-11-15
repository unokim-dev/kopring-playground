package com.example.kopringplaygound

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KopringPlaygoundApplicationTests(@Autowired private val objectMapper: ObjectMapper) {

    @Test
    fun enumTest() {
        println(objectMapper.writeValueAsString(TestClass("test", 10, Grade.A)))
        println(objectMapper.readValue("{\"name\":\"test\",\"age\":10,\"testValue\":\"잘했네\"}", TestClass::class.java))
    }

    @Test
    fun jsonIgnoreTest() {
        val  json = """{"age": 18}"""

        println(objectMapper.readValue(json, TestJsonBody::class.java))
    }

    data class TestClass(
        val name: String,
        val age: Int,
        @JsonProperty("testValue") val grade: Grade,
    )

    enum class Grade(@JsonValue val description: String) {
        A("잘했네"),
        B("했네"),
        C("그러네"),
    }

//    @JsonIgnoreProperties(ignoreUnknown = false)
    data class TestJsonBody(val name: String?, val age: Int?)
}
