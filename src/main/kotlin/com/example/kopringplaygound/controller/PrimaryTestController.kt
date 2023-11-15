package com.example.kopringplaygound.controller

import com.example.kopringplaygound.domain.PrimaryTestClass
import com.example.kopringplaygound.dto.request.PostBody
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PrimaryTestController(private val primaryTestClass: PrimaryTestClass) {

    @GetMapping(path = ["/primary"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun primary() = primaryTestClass.doThing()

    @PostMapping("/post-test")
    fun post(@RequestBody body: PostBody): ResultBody {
        val result = ResultBody(body.toString())
        println(result)
        return result
    }

    data class ResultBody(val message: String)
}
