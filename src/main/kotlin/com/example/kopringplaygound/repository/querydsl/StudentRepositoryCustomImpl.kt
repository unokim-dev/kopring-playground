package com.example.kopringplaygound.repository.querydsl

import com.example.kopringplaygound.domain.QBook.book
import com.example.kopringplaygound.domain.QStudent.student
import com.example.kopringplaygound.domain.Student
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import kotlin.math.max
import org.springframework.data.domain.Pageable

class StudentRepositoryCustomImpl(em: EntityManager) : StudentRepositoryCustom {

    private val queryFactory = JPAQueryFactory(em)

    override fun testQuerydsl(pageable: Pageable): List<Student> {
        val ids: List<Long> = queryFactory
//            .select(student.id)
//            .from(student)
            .selectFrom(student)
            .leftJoin(student.books, book).fetchJoin()
            .where(book.readable.isTrue)
            .fetch().map { it.id!! }

        val from = pageable.offset.toInt()
        val to = max((pageable.offset + pageable.pageSize).toInt(), ids.size)

        println("-------- $ids")
        println("------- offset: ${pageable.offset}")
        println("------- size: ${pageable.pageSize}")
        println("-------- paged: ${ids.subList(from, to)}")

        val query = queryFactory
            .selectFrom(student)
            .leftJoin(student.books, book).fetchJoin()
            .where(student.id.`in`(ids.subList(from, to)))
            .orderBy(student.createdAt.desc())

        return query.fetch()
    }
}