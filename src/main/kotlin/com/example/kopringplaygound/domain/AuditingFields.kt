package com.example.kopringplaygound.domain

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class AuditingFields {

    /** 생성일시 */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    lateinit var createdAt: LocalDateTime
        protected set

    /** 생성자 */
//    @CreatedBy
//    @Column(nullable = false, updatable = false)
//    lateinit var createdBy: String
//        protected set

    /** 수정일시 */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    lateinit var modifiedAt: LocalDateTime
        protected set

    /** 수정자 */
//    @LastModifiedBy
//    @Column(nullable = false, length = 100)
//    lateinit var modifiedBy: String
//        protected set

    override fun toString(): String {
//        return "AuditingFields(createdAt=$createdAt, createdBy='$createdBy', modifiedAt=$modifiedAt, modifiedBy='$modifiedBy')"
        return "AuditingFields(createdAt=$createdAt, modifiedAt=$modifiedAt)"
    }

}
