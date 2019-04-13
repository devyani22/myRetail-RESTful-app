package com.target.casestudy.utils;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class ApiResponse {

    private String message;

    public ApiResponse(String message) {
        this.message = message;
    }
}
