package com.example.kopringplaygound.service

import com.example.kopringplaygound.Sample
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service

@Service
class SampleService(private val objectMapper: ObjectMapper) {
    fun sample() {
        Sample("test", "test2")
    }
}
