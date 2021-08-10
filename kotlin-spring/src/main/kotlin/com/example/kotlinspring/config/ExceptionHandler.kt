package com.example.kotlinspring.config

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(value = [DataNotFoundException::class])
    fun notfound(e: RuntimeException) =
        ResponseEntity(ErrorResponse(false, e.message ?: "해당 데이터를 찾을 수 없습니다."), HttpStatus.NOT_FOUND)

    @ExceptionHandler(value = [BadRequestException::class])
    fun badRequest(e: RuntimeException) =
        ResponseEntity(ErrorResponse(false, e.message ?: "잘못된 요청입니다"), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(value = [NotAllowedException::class])
    fun notAllowed(e: RuntimeException) =
        ResponseEntity(ErrorResponse(false, e.message ?: "접근 권한이 없습니다."), HttpStatus.FORBIDDEN)
}

data class ErrorResponse(
    val ok: Boolean,
    val error: String
)

class DataNotFoundException(message: String? = null) : RuntimeException(message)

class BadRequestException(message: String? = null) : RuntimeException(message)

class NotAllowedException(message: String? = null) : RuntimeException(message)