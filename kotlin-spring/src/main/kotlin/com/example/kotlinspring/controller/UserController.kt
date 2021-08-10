package com.example.kotlinspring.controller

import com.example.kotlinspring.controller.request.CreateUserInput
import com.example.kotlinspring.controller.request.EditUserInput
import com.example.kotlinspring.controller.request.NameInput
import com.example.kotlinspring.controller.response.PageableResponse
import com.example.kotlinspring.controller.response.SuccessResponse
import com.example.kotlinspring.db.UserModel
import com.example.kotlinspring.service.UserService
import com.example.kotlinspring.service.command.CreateUser
import com.example.kotlinspring.service.command.EditUser
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.transaction.Transactional

@RequestMapping("kotlin")
@RestController
class UserController(
    private val userService: UserService,
) {
    @GetMapping("/me")
    fun getMe(
        @RequestHeader("USER-ID") userId: Long // 커스텀 HTTP HEADER 값을 통해 현재 사용자 식별
    ): SuccessResponse<UserModel> =
        SuccessResponse(data = userService.getMe(userId))

    @GetMapping("/user")
    fun getByName(
        @RequestBody nameInput: NameInput, // HTTP Body의 JSON 데이터를 해당 타입의 Object로 맵핑하여 받기
    ): SuccessResponse<UserModel> =
        SuccessResponse(data = userService.getByName(nameInput.name))

    @GetMapping("/users") // /kotlin/users?size=10&page=0
    fun getUsers(
        @PageableDefault(size = 10, page = 0, sort = ["id"], direction = Sort.Direction.DESC) pageable: Pageable
    ): PageableResponse<UserModel> =
        userService.getUsers(pageable).let {
            PageableResponse(
                data = it.content,
                size = it.content.size,
                offset = it.pageable.offset.toInt(),
                totalCount = it.totalElements.toInt(),
                hasNext = it.pageable.offset + it.size < it.totalElements
            )
        }

    @Transactional
    @PostMapping("/user")
    fun createUser(
        @RequestBody createUserInput: CreateUserInput,
    ): SuccessResponse<Unit> = // Unit은 Java의 void와 유사. 아무것도 반환하지 않는 형식의 반환형.
        SuccessResponse(
            data = userService.createUser(
                command = CreateUser(createUserInput.name, createUserInput.age)
            )
        )

    @Transactional
    @PutMapping("/user")
    fun editUser(
        @RequestHeader("USER-ID") userId: Long,
        @RequestBody editUserInput: EditUserInput,
    ): SuccessResponse<Unit> =
        SuccessResponse(
            data = userService.editUser(
                command = EditUser(editUserInput.name, editUserInput.age), userId = userId
            )
        )
}