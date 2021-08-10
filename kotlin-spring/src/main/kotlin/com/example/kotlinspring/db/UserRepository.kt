package com.example.kotlinspring.db

import java.util.Optional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

// Repository는 @Entity의 형식에 맞추어 SQL문을 자동 생성해주는 기능
interface UserRepository : JpaRepository<UserEntity, Long> {
    override fun findAll(pageable: Pageable): Page<UserEntity>
    fun findByName(name: String): Optional<UserEntity>
}