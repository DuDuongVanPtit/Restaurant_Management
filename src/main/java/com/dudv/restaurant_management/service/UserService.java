package com.dudv.restaurant_management.service;

import com.dudv.restaurant_management.model.response.ResponseDTO;
import com.dudv.restaurant_management.model.user.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> findAll();
    ResponseDTO active(Long id);
    ResponseDTO delete(Long id);
}
