package com.example.kopringplaygound.repository

import java.time.LocalDateTime

interface SoftDeleteEntity {
    var deletedAt: LocalDateTime?
}