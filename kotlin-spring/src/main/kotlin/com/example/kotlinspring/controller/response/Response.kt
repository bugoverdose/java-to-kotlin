package com.example.kotlinspring.controller.response

sealed class KotlinResponse

data class SuccessResponse<R>(
    val ok: Boolean = true,
    val data: R
) : KotlinResponse()
// Unit Return인 경우 디폴트 형식 : { "ok": true, "data": {} }


data class PageableResponse<R>(
    val ok: Boolean = true,
    val data: List<R>,
    val size: Int,
    val offset: Int,
    val totalCount: Int,
    val hasNext: Boolean
) : KotlinResponse()
