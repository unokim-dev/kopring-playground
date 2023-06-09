package com.example.kopringplaygound.repository.querydsl

import com.example.kopringplaygound.domain.QBook.book
import com.example.kopringplaygound.domain.QStudent.student
import com.example.kopringplaygound.domain.Student
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager

class StudentRepositoryCustomImpl(em: EntityManager) : StudentRepositoryCustom {

    private val queryFactory = JPAQueryFactory(em)

    override fun testQuerydsl(): List<Student> {
        val query = queryFactory
            .selectFrom(student)
            .leftJoin(student.books, book)
            .orderBy(student.createdAt.desc())
            .offset(0L)
            .limit(4L)

        return query.fetch()
    }
}