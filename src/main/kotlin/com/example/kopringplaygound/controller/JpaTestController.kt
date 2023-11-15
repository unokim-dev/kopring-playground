package com.example.kopringplaygound.controller

import com.example.kopringplaygound.domain.Book
import com.example.kopringplaygound.domain.Student
import com.example.kopringplaygound.repository.StudentRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JpaTestController(
    private val studentRepository: StudentRepository,
) {

    @Transactional
    @PostMapping("/jpa/exception-test")
    fun jpaTest(): Student {
        val student = studentRepository.save(Student.of("uno", Student.Grade.B))
        val book = Book.of("너무 긴 문자열_너무 긴 문자열_너무 긴 문자열_너무 긴 문자열_너무 긴 문자열_너무 긴 문자열_너무 긴 문자열", false)
        student.books.add(book)

        return studentRepository.saveAndFlush(student)
    }
}