package com.dudv.restaurant_management.service.impl;

import com.dudv.restaurant_management.Converter.UserConverter;
import com.dudv.restaurant_management.entity.Role;
import com.dudv.restaurant_management.entity.UserEntity;
import com.dudv.restaurant_management.entity.WorkScheduleEntity;
import com.dudv.restaurant_management.model.response.ResponseDTO;
import com.dudv.restaurant_management.model.user.UserResponseDTO;
import com.dudv.restaurant_management.repository.UserRepository;
import com.dudv.restaurant_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public List<UserResponseDTO> findAll() {
        List<UserEntity> userEntities = userRepository.findByRole(Role.STAFF);
        for (UserEntity user: userEntities){
            List<WorkScheduleEntity> workScheduleEntities = user.getWorkScheduleEntities();

            System.out.println("ok");
        }
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        for(UserEntity u: userEntities){
            userResponseDTOS.add(userConverter.toUserResponseDTO(u));
        }
        return userResponseDTOS;
    }

    @Override
    public ResponseDTO active(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        ResponseDTO responseDTO = new ResponseDTO();
        userEntity.setStatus(1);
        try {
            userRepository.save(userEntity);
            responseDTO.setMessage("Active Successfully");
        }
        catch (Exception e){
            responseDTO.setMessage("Error");
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO delete(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            userRepository.deleteById(id);
            responseDTO.setMessage("Delete Successfully");

        }
        catch (Exception e){
            responseDTO.setMessage("Error");
        }
        return responseDTO;
    }
}
