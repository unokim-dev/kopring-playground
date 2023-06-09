package com.example.kopringplaygound.repository

import com.example.kopringplaygound.domain.Book
import com.example.kopringplaygound.domain.Student
import org.hibernate.Session
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import jakarta.persistence.EntityManager

@DataJpaTest
internal class JpaTest @Autowired constructor(
    private val studentRepository: StudentRepository,
    private val bookRepository: BookRepository,
    private val entityManager: EntityManager,
    private val testEntityManager: TestEntityManager,
) {

    @Test
    fun asdf() {
        // Arrange
        studentRepository.save(Student.of("suzy", Student.Grade.B))
        val student = studentRepository.save(Student.of("uno", Student.Grade.A))
        bookRepository.saveAllAndFlush(
            listOf(
                Book.of("math", true),
                Book.of("english", false),
            )
        )

        // Act
        studentRepository.findAll().forEach {
            println(it)
            println(it.books)
        }



        // Assert

    }

    @Test
    fun `연결 정보 확인하는 법`() {
        val session = entityManager.delegate as Session
        session.doWork {
            println("------- metadata: ${it.metaData.url}")
        }
    }

    @Test
    fun `연결 정보 확인하는 법 (TestEntityManager)`() {
        val session = testEntityManager.entityManager.delegate as Session
        session.doWork {
            println("------- metadata: ${it.metaData.url}")
        }
    }
}