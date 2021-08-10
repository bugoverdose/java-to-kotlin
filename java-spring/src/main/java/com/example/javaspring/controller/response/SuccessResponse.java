package com.example.javaspring.controller.response;

import lombok.Data;

@Data
public class SuccessResponse<R> {
    Boolean ok = true;
    R data;

    public SuccessResponse(R data){
        this.data = data;
    }
}


