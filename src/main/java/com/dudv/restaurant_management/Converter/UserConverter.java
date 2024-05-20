package com.dudv.restaurant_management.Converter;

import com.dudv.restaurant_management.entity.UserEntity;
import com.dudv.restaurant_management.model.user.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private ModelMapper modelMapper;
    public UserResponseDTO toUserResponseDTO(UserEntity userEntity){
        UserResponseDTO userResponseDTO = modelMapper.map(userEntity, UserResponseDTO.class);
        return userResponseDTO;
    }
}
