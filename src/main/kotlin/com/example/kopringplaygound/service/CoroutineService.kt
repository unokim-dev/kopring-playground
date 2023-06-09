package com.example.kopringplaygound.service

import kotlinx.coroutines.coroutineScope

class CoroutineService {

    suspend fun routine() = coroutineScope {
        println("hello")
    }
}