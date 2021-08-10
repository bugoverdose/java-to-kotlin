package com.example.kotlinspring

import com.example.kotlinspring.service.UserService
import com.example.kotlinspring.service.command.CreateUser
import org.springframework.stereotype.Service
import kotlin.math.roundToLong

@Service
class DefaultData(
    private val userService: UserService
){
    val nameList = listOf(
        "jeong", "jinu", "jinwoo", "zinu", "henry", "liha", "mingsu", "cloud",
        "bunny bernie", "no more build", "woori", "stevy", "vegi",
        )

    fun init() {
        for (personName in nameList){
            userService.createUser(CreateUser(personName, (Math.random() * 120).roundToLong()))
        }
    }
}