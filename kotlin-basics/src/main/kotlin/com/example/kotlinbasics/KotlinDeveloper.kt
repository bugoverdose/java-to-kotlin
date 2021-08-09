package com.example.kotlinbasics

// data class는 Lombok의 @Data의 기능 + 상속 불가 제약을 거는 기능.
// 자동으로 equals, hashcode, toString 등의 메서드들 구현해줌.
// 다만 코틀린에서는 getter setter 기능을 사용하지 않음

// 생성자 형식 : 소괄호 내부에 매개변수 지정하여 정의.
data class KotlinDeveloper(
    val name : String, // 수정 불가능하도록 val 선언. 자바의 final, JS의 const
    var age : Int,
    var message : String = "응애! 나 애기 코틀린 개발자!"
)
// {} 부분 불필요. 생성자에서 사용될 멤버변수들을 별도로 {}에서 지정할 필요 없음.