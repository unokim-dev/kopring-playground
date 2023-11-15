package com.example.kopringplaygound.domain

import com.example.kopringplaygound.repository.SoftDeleteEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.Transient
import jakarta.persistence.UniqueConstraint
import java.time.LocalDateTime

@Table(
    uniqueConstraints = [UniqueConstraint(columnNames = ["name", "grade", "deletedAt"])]
)
@Entity
class Student protected constructor() : AuditingFields(), SoftDeleteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @JoinColumn(name = "studentId", nullable = false, updatable = false)
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var books: MutableSet<Book> = mutableSetOf()

    @Column(nullable = false)
    var name: String? = null

    @Enumerated(EnumType.STRING)
    var grade: Grade? = null

    //    @Transient
    @Column(insertable = false, updatable = false)
//    var deleted: Boolean = false
//        protected set
    override var deletedAt: LocalDateTime? = null

    private constructor(books: MutableSet<Book>, name: String?, grade: Grade?) : this() {
        this.books = books
        this.name = name
        this.grade = grade
    }

    private constructor(name: String?, grade: Grade?) : this() {
        this.name = name
        this.grade = grade
    }

    companion object {
        fun of(name: String?, grade: Grade?): Student = Student(name, grade)
        fun of(books: MutableSet<Book>, name: String?, grade: Grade?): Student = Student(books, name, grade)
    }

    enum class Grade { A, B, C, D, F }

    override fun toString(): String {
        return "Student(" +
                "id=$id, " +
                "books=$books, " +
                "name=$name, " +
                "grade=$grade, " +
                "deletedAt=$deletedAt" +
                ")"
    }
}
