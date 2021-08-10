package com.example.javaspring.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repository는 @Entity의 형식에 맞추어 SQL문을 자동 생성해주는 기능
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Page<UserEntity> findAll(Pageable pageable);

    Optional<UserEntity> findByName(String name);
}