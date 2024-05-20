package com.dudv.restaurant_management.service.impl;

import com.dudv.restaurant_management.Converter.WorkScheduleConverter;
import com.dudv.restaurant_management.entity.UserEntity;
import com.dudv.restaurant_management.entity.WorkManagementEntity;
import com.dudv.restaurant_management.entity.WorkScheduleEntity;
import com.dudv.restaurant_management.model.request.ScheduleRegistrationRequest;
import com.dudv.restaurant_management.model.response.ResponseDTO;
import com.dudv.restaurant_management.repository.UserRepository;
import com.dudv.restaurant_management.repository.WorkManagementRepository;
import com.dudv.restaurant_management.repository.WorkScheduleRepository;
import com.dudv.restaurant_management.service.WorkScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkScheduleServiceImpl implements WorkScheduleService {
    @Autowired
    private WorkScheduleRepository workScheduleRepository;
    @Autowired
    private WorkScheduleConverter workScheduleConverter;
    @Autowired
    private WorkManagementRepository workManagementRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseDTO save(List<ScheduleRegistrationRequest> scheduleRegistrationRequests, Long workManagementId, String staffEmail) throws ParseException {
        WorkManagementEntity workManagementEntity = workManagementRepository.findById(workManagementId).get();
        UserEntity userEntity = userRepository.findByStatusAndEmail(1, staffEmail).get();
        List<WorkScheduleEntity> workScheduleEntities = new ArrayList<>();
        for (ScheduleRegistrationRequest s: scheduleRegistrationRequests){
            workScheduleEntities.add(workScheduleConverter.toWorkScheduleEntity(s));
        }
        for (WorkScheduleEntity w : workScheduleEntities){
            w.setUser(userEntity);
            w.setWorkManagement(workManagementEntity);
            workScheduleRepository.save(w);
        }
        return null;
    }
}
