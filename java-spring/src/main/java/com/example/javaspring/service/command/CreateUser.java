package com.example.javaspring.service.command;

import com.example.javaspring.db.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateUser {
    String name;
    Long age;
    public UserEntity toEntity() {
        return new UserEntity(this.name, this.age);}
}
