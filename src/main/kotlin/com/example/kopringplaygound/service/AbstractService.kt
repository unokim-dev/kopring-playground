package com.example.kopringplaygound.service

abstract class AbstractService {
    open fun doSomething(str: String) {
        println("Abstract - $str")
    }
}