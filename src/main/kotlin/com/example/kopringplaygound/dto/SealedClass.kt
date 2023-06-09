package com.example.kopringplaygound.dto

import com.example.kopringplaygound.dto.constant.Subject
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id

@JsonTypeInfo(use = Id.NAME)
sealed class SealedClass {
    data class Paying(
        val reservationCode: String,
        val subject: Subject = Subject.ENGLISH,
    ) : SealedClass()
}
