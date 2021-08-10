package com.example.kotlinspring.util

import kotlin.math.floor

object GetColor {
    fun randomColor(list: List<String>): String {
        if (list.isEmpty())
            return listOf("Red", "Green", "Blue", "Black")[floor(Math.random() * 4).toInt()]
        return list[floor(Math.random() * list.size).toInt()]
    }
}