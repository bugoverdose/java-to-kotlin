package com.example.javaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JavaSpringApplication {

    private final DefaultData defaultData;

    public JavaSpringApplication(DefaultData defaultData) {
        this.defaultData = defaultData;
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringApplication.class, args);
    }

    @PostConstruct
    private void init() {
        defaultData.init();
    }
}
