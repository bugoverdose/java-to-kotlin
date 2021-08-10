package com.example.javaspring.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class PageableResponse<R> {
        Boolean ok  = true;
        List<R> data;
        int size;
        int offset;
        int totalCount;
        Boolean hasNext;

        public PageableResponse(List<R> data, int size, int offset, int totalCount, Boolean hasNext) {
                this.data = data;
                this.size = size;
                this.offset = offset;
                this.totalCount = totalCount;
                this.hasNext = hasNext;
        }
}