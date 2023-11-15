package com.example.kopringplaygound.domain

import com.example.kopringplaygound.domain.embeddable.MyDiscount
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Book protected constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

//    @ManyToOne(optional = false, cascade = [CascadeType.ALL])
//    private var student: Student? = null

//    @Column(nullable = false)
//    private var studentId: Long? = null

    @Column(nullable = false, length = 50)
    var subject: String? = null

    @Embedded
    var myDiscount: MyDiscount? = null

    private var readable: Boolean? = null


    private constructor(subject: String, readable: Boolean) : this() {
        this.subject = subject
        this.readable = readable
    }

    companion object {
        fun of(subject: String, readable: Boolean): Book {
            return Book(subject, readable)
        }
    }

//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other !is Book) return false
//
//        if (id != other.id) return false
//        if (studentId != other.studentId) return false
//        if (subject != other.subject) return false
//        return readable == other.readable
//    }

    override fun hashCode(): Int {
        return when (id) {
            null -> {
                var result = subject?.hashCode() ?: 0
                result = 31 * result + (readable?.hashCode() ?: 0)
                return result
            }
            else -> id.hashCode()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Book) return false

        return when (id) {
            // 영속화되지 않은 경우, 각 필드 비교
            0L -> {
                if (subject != other.subject) return false
                return readable == other.readable
            }
            // 영속화된 경우, id 비교
            else -> id == other.id
        }
    }

//    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String {
        return "Book(id=$id, subject=$subject, readable=$readable, myDiscount=$myDiscount)"
    }


}