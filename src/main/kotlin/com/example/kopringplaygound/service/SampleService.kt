package com.example.kopringplaygound.service

import com.example.kopringplaygound.Sample
import com.example.kopringplaygound.domain.SingletonIsNotConstant
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Service

@Service
class SampleService(private val objectMapper: ObjectMapper) {
    fun sample() {
        SingletonIsNotConstant.I_AM_NOT_CONSTANT
        Sample("test", "test2")
    }

    fun jackson(input: String): TeaTime {
        println("boo!")
        return objectMapper.readValue(input)
    }

    data class TeaTime(val cake: Cake, val name: String)

    enum class Cake(val desc: String) {
        BANANA("바나나"), CHOCO("초코")
    }
}
