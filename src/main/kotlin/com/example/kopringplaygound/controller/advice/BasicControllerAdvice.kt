package com.example.kopringplaygound.controller.advice

import com.example.kopringplaygound.extension.ThrowableExtensions.rootCause
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class BasicControllerAdvice : ResponseEntityExceptionHandler() {

    @ExceptionHandler
    protected fun handleDataAccessException(dae: DataAccessException, request: WebRequest): ResponseEntity<Any>? {
        logger.warn("에러 메시지: $dae --> ${dae.rootCause()}")

        return super.handleExceptionInternal(dae, null, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, request)
    }
}
