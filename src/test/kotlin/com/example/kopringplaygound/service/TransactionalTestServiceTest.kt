package com.example.kopringplaygound.service

import com.example.kopringplaygound.repository.StudentRepository
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class TransactionalTestServiceTest @Autowired constructor(
    private val sut: TransactionalTestService,
    private val studentRepository: StudentRepository
) {

    @Test
    fun test() {
        // Given

        // When
        catchThrowable { sut.transaction() }

        // Then
        println("result ---------------------- ")
        studentRepository.findAll().forEach {
            println(it)
        }
    }
}
