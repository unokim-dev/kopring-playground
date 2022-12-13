package com.example.kopringplaygound.service

import com.example.kopringplaygound.domain.Student
import com.example.kopringplaygound.repository.StudentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TransactionalTestService(
    private val studentRepository: StudentRepository
) {

    @Transactional
    fun transaction() {
        otherMethod()
    }

    fun otherMethod() {
        (1..10).forEach {
            if (it == 10) throw RuntimeException()
            studentRepository.save(Student.of("uno$it", Student.Grade.A))
        }
    }
}