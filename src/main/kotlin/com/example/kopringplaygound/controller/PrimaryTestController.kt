package com.example.kopringplaygound.controller

import com.example.kopringplaygound.domain.PrimaryTestClass
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PrimaryTestController(private val primaryTestClass: PrimaryTestClass) {

    @GetMapping(path = ["/primary"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun primary() = primaryTestClass.doThing()
}
