package com.example.kotlinspring.db

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

// @Entity는 DB의 users 테이블에 SQL문을 날리기 위한 도구 => UserRepository를 위한 형식
// 실제 DB와 1대1 대응되지만 테이블 구조와 다를 수 있음.
@Table(name = "users")
@Entity
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L, // PK 제약조건. 데이터 생성 시점에 값 자동 생성.

    val name: String,

    val age: Long
)