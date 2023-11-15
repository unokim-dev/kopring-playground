package com.example.kopringplaygound.repository

import com.example.kopringplaygound.domain.Student
import com.example.kopringplaygound.repository.querydsl.StudentRepositoryCustom

interface StudentRepository : SoftDeleteJpaRepository<Student, Long>, StudentRepositoryCustom {


}
