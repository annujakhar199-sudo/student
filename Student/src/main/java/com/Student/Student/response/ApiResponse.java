package com.Student.Student.response;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {

    public static final String SUCCESS="success";
    public static final String FAILURE="failure";

    public String status;
    public String message;
    public T data;

    public ApiResponse(String status,String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}