package com.example.kotlinspring.db

import com.example.kotlinspring.util.GetColor

// model은 Front로 보낼 응답에 사용될 객체의 형식
data class UserModel (
    val id: Long,
    val name: String,
    val age: Long,
    val favColor: String, // 실제 DB 테이블에 저장된 User 엔티티의 형식과 달라도 됨
){
    companion object {
        fun of(
            e: UserEntity,
            colorInput: String? = null,
            randomColor: String = GetColor.randomColor(listOf())
        ): UserModel =
            UserModel(
                id = e.id,
                name = e.name,
                age = e.age,
                favColor = colorInput ?: randomColor
            )
    }
}