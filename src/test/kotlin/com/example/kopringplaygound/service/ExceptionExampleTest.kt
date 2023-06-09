package com.example.kopringplaygound.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.RuntimeException

class ExceptionExampleTest {

    @Test
    fun test1() {
        // Arrange
        val sut = ExceptionExample { "input \"$it\" processed" }

        // Act
        val result = sut.logic()

        // Assert
        println(result)
    }

    @Test
    fun test2() {
        // Arrange
        val sut = ExceptionExample { throw RuntimeException("error") }

        // Act
        val result = sut.logic()

        // Assert
        println(result)
    }

    @Test
    fun test3() {
        // Arrange
        val sut = ExceptionExample { throw Exception("fatal") }

        // Act
        val result: Throwable = Assertions.catchThrowable { sut.logic() }

        // Assert
        println(result)
    }
}