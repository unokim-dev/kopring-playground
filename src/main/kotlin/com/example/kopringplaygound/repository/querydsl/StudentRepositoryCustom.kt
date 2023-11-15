package com.example.kopringplaygound.repository.querydsl

import com.example.kopringplaygound.domain.Student
import org.springframework.data.domain.Pageable

interface StudentRepositoryCustom {
    fun testQuerydsl(pageable: Pageable): List<Student>
}
