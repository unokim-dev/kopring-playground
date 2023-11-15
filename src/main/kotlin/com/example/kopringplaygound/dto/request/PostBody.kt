package com.example.kopringplaygound.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive

data class PostBody(
    @field:Positive(message = "회원 ID는 유효한 자연수여야 합니다.")
    val id: Long,

    @field:NotEmpty(message = "회원 이름을 입력해 주세요.")
    val name: String,

    val memberType: PostType?,
) {
    enum class PostType { AAA, BBB, CCC }
}
