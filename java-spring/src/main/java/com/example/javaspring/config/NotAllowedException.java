package com.example.javaspring.config;

import lombok.Data;

@Data
public class NotAllowedException extends RuntimeException {
    public NotAllowedException(String message) { super(message); } // RuntimeException(message) 호출
}