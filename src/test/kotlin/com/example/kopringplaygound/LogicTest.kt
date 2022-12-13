package com.example.kopringplaygound

import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class LogicTest {
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