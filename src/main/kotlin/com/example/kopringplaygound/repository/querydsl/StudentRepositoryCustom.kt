package com.example.kopringplaygound.repository.querydsl

import com.example.kopringplaygound.domain.Student

interface StudentRepositoryCustom {
    fun testQuerydsl(): List<Student>
}