package com.example.kopringplaygound.config

import com.example.kopringplaygound.domain.PrimaryTestClass
import mu.KotlinLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

private val logger = KotlinLogging.logger {}

@Configuration
class PrimaryConfig {

    @Bean
    fun primaryTestClass(defaultPrimaryTestClass: PrimaryTestClass): PrimaryTestClass = PrimaryTestClass {
        try {
//            "this is primary implementation"
            throw RuntimeException("헐")
        } catch (e: Exception) {
            logger.warn { "primary failed. run default" }
            defaultPrimaryTestClass.doThing()
        }
    }
}
