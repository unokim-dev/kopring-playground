package com.example.kopringplaygound.repository

import com.example.kopringplaygound.config.JpaConfig
import com.example.kopringplaygound.domain.AuditingTable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@Import(JpaConfig::class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class JpaActualDBTest @Autowired constructor(
    private val auditingTableRepository: AuditingTableRepository,
) {

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