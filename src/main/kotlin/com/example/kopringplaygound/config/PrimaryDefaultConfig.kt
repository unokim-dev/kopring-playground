package com.example.kopringplaygound.config

import com.example.kopringplaygound.domain.PrimaryTestClass
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PrimaryDefaultConfig {

    @Bean
    fun defaultPrimaryTestClass(): PrimaryTestClass = PrimaryTestClass { "this is default implementation" }
}
