package com.example.javaspring.config;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) { super(message); } // RuntimeException(message) 호출
}
