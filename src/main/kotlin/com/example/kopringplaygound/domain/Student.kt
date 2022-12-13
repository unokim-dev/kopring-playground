package com.example.kopringplaygound.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
open class Student protected constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        private set

    @Column(nullable = false)
    var name: String? = null

    var grade: Grade? = null

    private constructor(name: String?, grade: Grade?) : this() {
        this.name = name
        this.grade = grade
    }

    companion object {
        fun of(name: String?, grade: Grade?): Student = Student(name, grade)
    }

    enum class Grade { A, B, C, D, F }

    override fun toString(): String {
        return "Student(id=$id, name=$name, grade=$grade)"
    }
}
