package com.dudv.restaurant_management.model.user;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String gender;
    private String role;
    private int status;
}
