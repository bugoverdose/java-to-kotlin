package com.example.javaspring.controller;

import com.example.javaspring.controller.request.NameInput;
import com.example.javaspring.controller.request.UserInput;
import com.example.javaspring.controller.response.PageableResponse;
import com.example.javaspring.controller.response.SuccessResponse;
import com.example.javaspring.db.UserModel;
import com.example.javaspring.service.UserService;
import com.example.javaspring.service.command.CreateUser;
import com.example.javaspring.service.command.EditUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RequestMapping("java")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public SuccessResponse<UserModel> getMe(
            @RequestHeader("USER-ID") Long userId // 커스텀 HTTP HEADER 값을 통해 현재 사용자 식별
    ){
        return new SuccessResponse<>(userService.getMe(userId));
    }

    @GetMapping("/user")
    public SuccessResponse<UserModel> getByName(
            @RequestBody NameInput nameInput // HTTP Body의 JSON 데이터를 해당 타입의 Object로 맵핑하여 받기
    ){
        return new SuccessResponse<>(userService.getByName(nameInput.getName()));
    }
    @GetMapping("/users")
    public PageableResponse<UserModel> getUsers(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<UserModel> userModels = userService.getUsers(pageable);
        return new PageableResponse<>(
                userModels.getContent(),
                userModels.getContent().size(),
                (int) userModels.getPageable().getOffset(),
                (int) userModels.getTotalElements(),
                userModels.getPageable().getOffset() + userModels.getSize() < userModels.getTotalElements()
        );
    }

    @Transactional
    @PostMapping("/user")
    public SuccessResponse<UserModel> createUser(
            @RequestBody UserInput createUserInput
    ){
        return new SuccessResponse<>(
                userService.createUser(new CreateUser(createUserInput.getName(), createUserInput.getAge()))
        );
    }

    @Transactional
    @PutMapping("/user")
    public SuccessResponse<UserModel> editUser(
            @RequestHeader("USER-ID") Long userId,
            @RequestBody UserInput editUserInput
    ) {
        return new SuccessResponse<>(
                userService.editUser(
                        new EditUser(editUserInput.getName(), editUserInput.getAge()), userId)
        );
    }
}