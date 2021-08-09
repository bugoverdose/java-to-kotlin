package com.example.javabasics;

public class JavaDeveloper {
    final public String name; // 자바의 final == 코틀린의 val 선언. JS의 const 선언과 유사. // 세터 자동 생성도 예방됨
    public int age;
    public String message = "응애! 나 애기 자바 개발자!";

    // 생성자 기본 형식: 클래스명과 동일한 이름. 반환형이 없음(언제나 해당 인스턴스를 반환).
    // constructor overloading : 복수의 생성자 정의. 매개변수 구성의 차이.
    public JavaDeveloper(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public JavaDeveloper(String name, int age, String message) {
        this.name = name;
        this.age = age;
        this.message = message;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "JavaDeveloper{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", message='" + message + '\'' +
                '}';
    }
}
