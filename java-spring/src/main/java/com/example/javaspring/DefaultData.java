package com.example.javaspring;

import com.example.javaspring.service.UserService;
import com.example.javaspring.service.command.CreateUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DefaultData {

    private final UserService userService;

    public DefaultData(UserService userService) {
        this.userService = userService;
    }

    ArrayList<String> nameList = new ArrayList<>(Arrays.asList(
            "jeong", "jinu", "jinwoo", "zinu", "henry", "liha", "mingsu", "cloud",
            "bunny bernie", "no more build", "woori", "stevy", "vegi"
    ));

    public void init() {
        for (String personName : nameList) {
            userService.createUser(new CreateUser(personName, (Long) Math.round(Math.random() * 120)));
        }
    }
}
