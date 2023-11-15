package com.example.kopringplaygound.repository

import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.transaction.annotation.Transactional

@NoRepositoryBean
interface SoftDeleteJpaRepository<T : SoftDeleteEntity, ID : Any> {

    fun deleteById(id: ID)
    fun delete(entity: T)
//    fun delete(spec: Specification<T>): Long
    fun deleteAllById(ids: MutableIterable<ID>)
    fun deleteAll(entities: MutableIterable<T>)
    fun deleteAll()
    fun deleteAllInBatch(entities: MutableIterable<T>)
    fun deleteAllInBatch()
    fun deleteAllByIdInBatch(ids: MutableIterable<ID>)

    @Deprecated("Use deleteAllInBatch(Iterable) instead.", ReplaceWith("deleteAllInBatch(Iterable)"))
    @Transactional
    fun deleteInBatch(entities: MutableIterable<T>)
}
