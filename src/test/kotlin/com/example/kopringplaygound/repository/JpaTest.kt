package com.example.kopringplaygound.repository

import jakarta.persistence.EntityManager
import org.hibernate.Session
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class JpaTest @Autowired constructor(
    private val entityManager: EntityManager,
    private val testEntityManager: TestEntityManager,
) {

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
