package com.example.kopringplaygound.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class AuditingTable(
    @Column(nullable = false) var nonnullField: String,
    var nullField: String?,
) : AuditingFields() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

//    protected constructor() : this("", null)

    override fun equals(that: Any?): Boolean {
        if (this === that) return true
        if (that !is AuditingTable) return false

        return this.id == that.id
    }

    override fun hashCode(): Int {
        return id.hashCode() ?: 0
    }

    override fun toString(): String {
        return "AuditingTable(nonnullField='$nonnullField', nullField=$nullField, id=$id, ${super.toString()})"
    }

}
