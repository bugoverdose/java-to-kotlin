package com.example.kotlinbasics

fun main(args: Array<String>) {

    // 1) 문법 간결화. 중괄호도 생략 가능
    println("Hello World!") // Hello World!

    // 2) 대입되는 값에 따라 기본적으로 자료형이 지정됨.
    val stringType = "문자열 타입 지정 불필요"
    val numberType: Int = 10 // 명시적으로 타입 지정도 가능 (TS와 유사)

    // 3) 변수 선언시 val 혹은 var로 선언 필요.
    val likeConst = "value"
    // likeConst = "can not change a value" // 컴파일 에러
    var likeLet = "variable" // Java의 자료형 추론 기능과 결과적으로 동일 형식
    likeLet = "can change a variable"
    println(likeLet); // can change a variable

    // 4) 모든 자료형은 기본적으로 non nullable
    var nullableString: String? = null
    var normalString: String
    // normalString = null // 컴파일 에러

    // 5) 모든 자료형은 nullable일 수 있음. 이 때문에 safe call 등 null 값 체크 관련 기능이 많음
    var nullableInt: Int? = null
    var normalInt: Int
    // normalInt = null // 컴파일 에러
    println(nullableInt?.toString()) // safe call(?.)

    // 6) new 키워드로 생성자 사용하여 인스턴스 생성.
    val baby = KotlinDeveloper("지누", 1, "웅 아무것도 몰라요")
    println(baby);
    // KotlinDeveloper(name=지누, age=1, message=웅 아무것도 몰라요)

    // 7) 멤버변수의 값에 직접 접근 가능하여 값 수정. 자유롭게 수정 가능한 멤버변수로 지정하려면 var로 선언
    println(baby.name) // 지누
    // baby.name = "개명 왜 안됨" // 컴파일 에러 : val 선언
    baby.age = 30
    baby.message = "사실 아직도 잘 몰라요"
    println(baby);
    // KotlinDeveloper(name=지누, age=30, message=사실 아직도 잘 몰라요)

    // 8) scope function
    // 일반적으로 변수 할당하여 작업하는 방식
    fun verbose(): String {
        val listData = listOf("a", "b", "c")
        return listData[0]
    }
    // 코틀린에서 한줄에 작업하는 방식 (주의. scope function 중첩 사용시 depth 증가로 가독성 감소)
    fun scopeFunc(): String = listOf("a", "b", "c").let { it[0] }
}