package com.example.kopringplaygound.repository

import jakarta.persistence.EntityManager
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.support.JpaEntityInformation
import org.springframework.data.jpa.repository.support.SimpleJpaRepository
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

class StudentRepositoryImpl<T : SoftDeleteEntity, ID : Any>(
//    entityInformation: JpaEntityInformation<T, *>,
//    em: EntityManager,
    private val jpaRepository: SimpleJpaRepository<T, ID>,
) : SoftDeleteJpaRepository<T, ID> {

    @Transactional
    override fun deleteById(id: ID) {
        val entity = jpaRepository.getReferenceById(id)
        entity.deletedAt = LocalDateTime.now()
    }

    @Transactional
    override fun delete(entity: T) {
        entity.deletedAt = LocalDateTime.now()
    }

    /** 이거 쓰지 말 것 */
//    @Transactional
//    override fun delete(spec: Specification<T>): Long {
////        super.delete(spec)
//        TODO("잘 안 쓰는거..나중에 구현해보자...")
//    }

    @Transactional
    override fun deleteAllById(ids: MutableIterable<ID>) {
        ids.forEach { this.deleteById(it) }
    }

    @Transactional
    override fun deleteAll(entities: MutableIterable<T>) {
        entities.forEach { this.delete(it) }
    }

    @Transactional
    override fun deleteAll() {
        findAll().forEach { this.delete(it) }
    }

    /** 이거 쓰지 말 것 */
    @Transactional
    override fun deleteAllInBatch(entities: MutableIterable<T>) {
//        super.deleteAllInBatch(entities)
        TODO("잘 안 쓰는거..나중에 구현해보자...")
    }

    /** 이거 쓰지 말 것 */
    @Transactional
    override fun deleteAllInBatch() {
//        super.deleteAllInBatch()
        TODO("잘 안 쓰는거..나중에 구현해보자...")
    }

    @Transactional
    override fun deleteAllByIdInBatch(ids: MutableIterable<ID>) {
//        super.deleteAllByIdInBatch(ids)
        TODO("잘 안 쓰는거..나중에 구현해보자...")
    }

    /** 이거 쓰지 말 것 */
    @Deprecated("Use deleteAllInBatch(Iterable) instead.", ReplaceWith("deleteAllInBatch(Iterable)"))
    @Transactional
    override fun deleteInBatch(entities: MutableIterable<T>) {
//        super.deleteInBatch(entities)
        TODO("잘 안 쓰는거..나중에 구현해보자...")
    }
}
