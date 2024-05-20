package com.dudv.restaurant_management.model.response;

import lombok.Data;

@Data
public class ResponseDTO {
    private Object data;
    private String message;
    private String detail;
}
