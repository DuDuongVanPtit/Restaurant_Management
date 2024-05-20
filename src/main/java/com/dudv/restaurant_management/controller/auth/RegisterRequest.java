package com.dudv.restaurant_management.controller.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "*Full name can't be left blank")
    private String fullName;

    @NotBlank(message = "*Email is required")
    @Email(message = "*Email is not valid")
    private String email;

    @Size(min = 1, message = "*Password must be at least 5 characters")
    private String password;

    @NotBlank(message = "*Repassword is required")
    private String rePassword;

    private String avatar;
    private String gender;
    private String address;

    @NotBlank(message = "*Phone number is required")
    private String phone;
    private String birthday;
}
