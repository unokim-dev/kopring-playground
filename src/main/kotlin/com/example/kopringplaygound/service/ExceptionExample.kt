package com.example.kopringplaygound.service

class ExceptionExample(private val dependentLogic: DependentLogic) {

    fun logic(): String {
        try {
            return dependentLogic.logic("hello world!")
        } catch (e: RuntimeException) {
            return "error: $e"
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
        finally {
            println("finally")
        }
    }

    fun interface DependentLogic {
        fun logic(input: String): String
    }
}
