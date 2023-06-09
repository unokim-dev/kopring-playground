package com.example.kopringplaygound.repository

import com.example.kopringplaygound.domain.Student
import com.example.kopringplaygound.repository.querydsl.StudentRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long>, StudentRepositoryCustom
