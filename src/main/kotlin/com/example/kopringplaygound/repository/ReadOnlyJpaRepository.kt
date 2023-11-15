package com.example.kopringplaygound.repository

import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery
import java.util.Optional
import java.util.function.Function

@NoRepositoryBean
interface ReadOnlyJpaRepository<T, ID> : Repository<T, ID> {

    // JpaRepository Methods
    fun flush()
//    fun <S : T?> saveAndFlush(entity: S): S
//    fun <S : T?> saveAllAndFlush(entities: Iterable<S>?): List<S>?
//    fun deleteAllInBatch(entities: Iterable<T?>?)
//    fun deleteAllByIdInBatch(ids: Iterable<ID?>?)
//    fun deleteAllInBatch()
    fun getOne(id: ID?): T?
    fun getById(id: ID?): T?
    fun getReferenceById(id: ID?): T?
    fun <S : T?> findAll(example: Example<S>?): List<S>?
    fun <S : T?> findAll(example: Example<S>?, sort: Sort?): List<S>?

    // QueryByExampleExecutor Methods
    fun <S : T?> findOne(example: Example<S>?): Optional<S>?
    fun <S : T?> findAll(example: Example<S>?, pageable: Pageable?): Page<S>?
    fun <S : T?> count(example: Example<S>?): Long
    fun <S : T?> exists(example: Example<S>?): Boolean
    fun <S : T?, R> findBy(example: Example<S>?, queryFunction: Function<FetchableFluentQuery<S>?, R>?): R

    // ListCrudRepository Methods
//    fun <S : T?> saveAll(entities: Iterable<S>?): List<S>?
    fun findAll(): List<T>?
    fun findAllById(ids: Iterable<ID>?): List<T>?

    // CrudRepository Methods
//    fun <S : T?> save(entity: S): S
    fun findById(id: ID): Optional<T>?
    fun existsById(id: ID): Boolean
    fun count(): Long
//    fun deleteById(id: ID)
//    fun delete(entity: T)
//    fun deleteAllById(ids: Iterable<ID>?)
//    fun deleteAll(entities: Iterable<T>?)
//    fun deleteAll()

    // ListPagingAndSortingRepository Methods
    fun findAll(sort: Sort?): MutableList<T?>?

    // PagingAndSortingRepository Methods
    fun findAll(pageable: Pageable?): Page<T>?
}