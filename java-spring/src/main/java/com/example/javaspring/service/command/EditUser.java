package com.example.javaspring.service.command;

import com.example.javaspring.db.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EditUser {
    String name;
    Long age;
}
