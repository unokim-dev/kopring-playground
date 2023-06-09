package com.example.kopringplaygound.repository

import com.example.kopringplaygound.domain.AuditingTable
import org.springframework.data.jpa.repository.JpaRepository

interface AuditingTableRepository : JpaRepository<AuditingTable, Long>