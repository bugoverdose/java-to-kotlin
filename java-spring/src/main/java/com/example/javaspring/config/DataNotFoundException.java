package com.example.javaspring.config;

import lombok.Data;

@Data
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(){ this(null); }

    public DataNotFoundException(String message) {
        super(message);
    } // RuntimeException(message) 호출
}