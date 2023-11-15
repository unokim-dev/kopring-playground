package com.example.kopringplaygound.repository

import com.example.kopringplaygound.config.JpaConfig
import com.example.kopringplaygound.domain.AuditingTable
import com.example.kopringplaygound.domain.Book
import com.example.kopringplaygound.domain.Student
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.test.annotation.Commit
import java.time.LocalDateTime

@Import(JpaConfig::class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class JpaActualDBTest @Autowired constructor(
    private val auditingTableRepository: AuditingTableRepository,
    private val bookRepository: BookRepository,
    private val studentRepository: StudentRepository,
) {

    @Test
    fun `너무 긴 문자열 입력으로 인한 db 예외 발생 처리`() {
        // Arrange
        val student = studentRepository.save(Student.of("uno", Student.Grade.B))
        val book = Book.of("너무 긴 문자열_너무 긴 문자열_너무 긴 문자열_너무 긴 문자열_너무 긴 문자열_너무 긴 문자열_너무 긴 문자열", false)
        student.books.add(book)

        // Act
        studentRepository.saveAndFlush(student)

        // Assert
    }

    @Test
    fun manyToOneTest() {
        // Arrange

        // Act
        val result = bookRepository.save(Book.of("math", true))

        // Assert
        println(result)
    }

    @Commit
    @Test
    fun oneToManyTest() {
        // Arrange

        // Act
        val result = studentRepository.save(
            Student.of(mutableSetOf(Book.of("math", true)), "uno", Student.Grade.A)
        )

        // Assert
        println(result)
    }


    @Test
    fun insert() {
        // Arrange

        // Act
        val result = auditingTableRepository.save(AuditingTable("hi", null))

        // Assert
        println("created_at: ${result.createdAt}")
        println("modified_at: ${result.modifiedAt}")
        println("object: $result")
        assertThat(result.nullField).isEqualTo(null)
        assertThat(result.createdAt).isEqualTo(result.modifiedAt)
    }

    @RepeatedTest(100)
    fun update() {
        // Arrange
        val a = auditingTableRepository.save(AuditingTable("hi", null))
        a.nullField = "wow"

        // Act
        val result = auditingTableRepository.saveAndFlush(a)

        // Assert
        println("created_at: ${result.createdAt}")
        println("modified_at: ${result.modifiedAt}")
        assertThat(result.nullField).isEqualTo("wow")
        assertThat(result.createdAt).isBefore(result.modifiedAt)
    }

    @Test
    fun insertIdZero() {
        // Arrange
        val a = AuditingTable("hi", null)
        a.id = 0L

        // Act
        val result = auditingTableRepository.save(a)

        // Assert
        assertThat(result.id).isNotEqualTo(0L)
    }

    @Test
    fun insertIdNull() {
        // Arrange
        val a = AuditingTable("hi", null)
//        a.id = null

        // Act
        println("--- id: ${a.id}")
        val result = auditingTableRepository.save(a)

        // Assert
        assertThat(result.id).isNotEqualTo(0L)
    }
}