package com.example.kopringplaygound.repository.querydsl

import com.example.kopringplaygound.config.JpaConfig
import com.example.kopringplaygound.domain.Book
import com.example.kopringplaygound.domain.Student
import com.example.kopringplaygound.repository.StudentRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.annotation.Commit

@Import(JpaConfig::class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class StudentRepositoryCustomImplTest @Autowired constructor(
    private val studentRepository: StudentRepository,
) {

    @Commit
    @Test
    fun querydslTest() {
        // Arrange
        studentRepository.saveAll(
            listOf(
                Student.of("uno", Student.Grade.A).apply {
                    books.addAll(
                        listOf(
                            Book.of("math", true),
                            Book.of("math2", true),
                            Book.of("math3", true),
                            Book.of("math4", true),
                        )
                    )
                },
                Student.of("mark", Student.Grade.B).apply {
                    books.addAll(
                        listOf(
                            Book.of("english", true),
                            Book.of("english2", true),
                            Book.of("english3", true),
                        )
                    )
                }
            )
        )

        println("\n\n\n\n\n")

        // Act
        val result = studentRepository.testQuerydsl()

        // Assert
        println(result)
    }
}