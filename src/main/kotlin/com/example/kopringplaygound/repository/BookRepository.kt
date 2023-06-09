package com.example.kopringplaygound.repository;

import com.example.kopringplaygound.domain.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {
}