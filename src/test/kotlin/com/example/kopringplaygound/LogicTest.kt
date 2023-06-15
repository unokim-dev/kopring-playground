package com.example.kopringplaygound

import com.example.kopringplaygound.domain.MyClass
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.RuntimeException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period

internal class LogicTest {

    @Test
    fun substringTest() {
        val short = "hello there"
        val long  = "hello there 123456789 123456789 123456789 123456789 123456789 123456789"
        println(long.take(20))
        println(short.take(20))
    }

    @Test
    fun subListTest() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7)

        println(list.subList(0, 6))
        println(list.subList(0, 7))
        println(list.subList(6, 7))
        println(list.subList(7, 7))
    }

    @Test
    fun qusetionMarkTest() {
        val a: QuestionFields? = null
        val asdf: Long? = null

        println(a?.wow(100))
    }

    data class QuestionFields(val name: String, val money: Int) {
        fun wow(x: Int) = money == x
    }

    @Test
    fun asdfasdF() {
        println(LocalDate.of(2022, 2, 4).isBefore(LocalDate.of(2022, 2, 3)))
    }

    @Test
    fun stringContains() {
        println("asdfasdf".contains("asdf"))
    }

    @Test
    fun timerTest() {
        val ceh = CoroutineExceptionHandler { _, e ->
            println("asdfasdf, $e")
        }

//        val job = CoroutineScope(Dispatchers.IO).launch(ceh) {
//            repeat(5) {
//                println("hello world")
//                delay(1000L)
//                throw RuntimeException("썸띵롱")
//            }
//        }

        runBlocking {
            routine()
            delay(4_000L)
//            job.cancel()
        }
    }

    suspend fun routine() {
        repeat(5) {
            println("hello world")
            delay(1000L)
//            throw RuntimeException("썸띵롱")
        }
    }

    @Test
    fun test() {
        val travels = RelatedTravels(
            listOf(RelatedTravel("1", LocalDate.now(), 1)),
            listOf(RelatedTravel("1", LocalDate.now(), 1))
        )

        println(travels)
        println(travels.source) // error "lateinit property source has not been initialized"
    }

    @Test
    fun ttt() {
        val str = "[[item1-1, item1-2], [item2-1, item2-2]]"

        val pair = listOf(Pair("aaa", "bbb"), Pair("ccc", "ddd"))
        println(pair)
        println(pair.joinToString())
        println(pair.toString())
    }

    @Test
    fun joinString() {
        val list = listOf("I", "am", "your", "father")
        println(list.joinToString())
    }

    @Test
    fun assertjTest() {
        val myClass = MyClass("test", MyClass.InnerClass("Hi"))

        Assertions.assertThat(myClass)
            .hasFieldOrPropertyWithValue("str", "test")
            .hasFieldOrPropertyWithValue("inner.name", "Hi")
            .hasFieldOrPropertyWithValue(MyClass::inner.name, "Hi")
    }

    data class RelatedTravels(
        val before: List<RelatedTravel>,
        val after: List<RelatedTravel>
    ) {
        lateinit var source: RelatedTravel
    }

    data class RelatedTravel(
        val id: String,
        val startDate: LocalDate,
        val adultPrice: Int
    )
}