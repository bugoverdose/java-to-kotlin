package com.example.kotlinspring.service.command

import com.example.kotlinspring.db.UserEntity

sealed class UserCommand

data class CreateUser(
    val name: String,
    val age: Long,
) : UserCommand() {
    fun toEntity() = UserEntity(name = name, age = age)
}

data class EditUser(
    val name: String?,
    val age: Long?,
) : UserCommand()