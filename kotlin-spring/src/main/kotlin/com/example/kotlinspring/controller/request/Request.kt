package com.example.kotlinspring.controller.request

data class NameInput(
    val name: String
)

data class CreateUserInput(
    val name: String,
    val age: Long
)

data class EditUserInput(
    val name: String?,
    val age: Long?
)
