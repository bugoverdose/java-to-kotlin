package com.example.kotlinspring.service

import com.example.kotlinspring.config.BadRequestException
import com.example.kotlinspring.config.DataNotFoundException
import com.example.kotlinspring.db.UserModel
import com.example.kotlinspring.db.UserRepository
import com.example.kotlinspring.service.command.CreateUser
import com.example.kotlinspring.service.command.EditUser
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
){
    fun getMe(userId: Long): UserModel =
        userRepository.findById(userId).orElseThrow(::DataNotFoundException).let {
            UserModel.of(it)
        }

    fun getByName(name: String): UserModel =
        userRepository.findByName(name).orElseThrow(::DataNotFoundException).let {
            UserModel.of(it)
        }

    fun getUsers(pageable: Pageable): Page<UserModel> =
        userRepository.findAll(pageable).map { UserModel.of(it) }

    fun createUser(command: CreateUser){
        if (userRepository.findByName(command.name).isPresent)
            throw BadRequestException("이미 사용되는 이름입니다.")
        userRepository.save(command.toEntity())
    }

    fun editUser(command: EditUser, userId: Long){
        userRepository.findById(userId).orElseThrow(::DataNotFoundException).let {
            if (command.name == it.name && command.age == it.age)
                throw BadRequestException("수정 사항이 없습니다.") // 불필요한 트랜잭션 작업 방지

            // val이기 때문에 별도의 인스턴스 생성하여 해당 엔티티 업데이트하는 트랜잭션 직접 보내기
            userRepository.save(it.copy(
                name = command.name ?: it.name, // 수정하기 위해 값을 입력받은 필드만 변경되어 저장됨
                age = command.age ?: it.age
            ))
        }
    }
}
