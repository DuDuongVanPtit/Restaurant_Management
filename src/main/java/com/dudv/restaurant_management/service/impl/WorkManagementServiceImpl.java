package com.dudv.restaurant_management.service.impl;

import com.dudv.restaurant_management.Converter.WorkManagementConverter;
import com.dudv.restaurant_management.Utils.DateUtils;
import com.dudv.restaurant_management.entity.WorkManagementEntity;
import com.dudv.restaurant_management.entity.WorkScheduleEntity;
import com.dudv.restaurant_management.model.request.admin.CreateScheduleRequest;
import com.dudv.restaurant_management.model.response.ResponseDTO;
import com.dudv.restaurant_management.model.response.WorkManagementDTO;
import com.dudv.restaurant_management.repository.WorkManagementRepository;
import com.dudv.restaurant_management.service.WorkManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Service
public class WorkManagementServiceImpl implements WorkManagementService {
    @Autowired
    private WorkManagementRepository workManagementRepository;
    @Autowired
    private WorkManagementConverter workManagementConverter;
    @Autowired
    private DateUtils dateUtils;
    @Override
    public ResponseDTO save(CreateScheduleRequest createScheduleRequest) throws ParseException {
        ResponseDTO responseDTO = new ResponseDTO();
        WorkManagementEntity workManagementEntity = workManagementConverter.toWorkManagementEntity(createScheduleRequest);
        WorkManagementEntity workManagement = workManagementRepository.findByStartDateAndEndDate(workManagementEntity.getStartDate(), workManagementEntity.getEndDate());
        if(workManagement == null){
            try {
                workManagementRepository.save(workManagementEntity);
                responseDTO.setMessage("Create schedule successfully");
            }
            catch (Exception e){
                responseDTO.setMessage(e.getMessage());
            }
        }
        else {
            responseDTO.setMessage("Schedule has been created");
        }
        return responseDTO;
    }

    public WorkManagementDTO findByStartDateAndEndDate(String stringDate) throws ParseException {
        String[] date = stringDate.split("-");
        Date startDate = dateUtils.getDate1(date[0]);
        Date endDate = dateUtils.getDate1(date[1]);
        WorkManagementEntity workManagementEntity = workManagementRepository.findByStartDateAndEndDate(startDate, endDate);
        return workManagementConverter.toWorkManagementDTO(workManagementEntity);
    }
}
