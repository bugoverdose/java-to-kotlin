package com.example.kotlinspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class KotlinSpringApplication(
    private val defaultData: DefaultData
){
    @PostConstruct
    private fun init(): Unit {
        defaultData.init()
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinSpringApplication>(*args)
}
