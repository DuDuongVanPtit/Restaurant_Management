package com.dudv.restaurant_management.Converter;

import com.dudv.restaurant_management.Utils.DateUtils;
import com.dudv.restaurant_management.entity.WorkManagementEntity;
import com.dudv.restaurant_management.entity.WorkScheduleEntity;
import com.dudv.restaurant_management.model.request.admin.CreateScheduleRequest;
import com.dudv.restaurant_management.model.response.CreateScheduleResponseDTO;
import com.dudv.restaurant_management.model.response.WorkManagementDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class WorkManagementConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    DateUtils dateUtils;

    public CreateScheduleResponseDTO toCreateScheduleResponseDTO(WorkManagementEntity workManagementEntity){
        CreateScheduleResponseDTO createScheduleResponseDTO = modelMapper.map(workManagementEntity, CreateScheduleResponseDTO.class);
        return createScheduleResponseDTO;
    }

    public WorkManagementEntity toWorkManagementEntity(CreateScheduleRequest createScheduleRequest) throws ParseException {
        WorkManagementEntity workManagementEntity = modelMapper.map(createScheduleRequest, WorkManagementEntity.class);
        String[] description = createScheduleRequest.getDateDescription().split("-");
        String des = description[0];
        String startDate = description[1];
        String endDate = description[2];
        workManagementEntity.setDescription(des);
        workManagementEntity.setStartDate(dateUtils.getDate1(startDate));
        workManagementEntity.setEndDate(dateUtils.getDate1(endDate));
        return workManagementEntity;
    }

    public WorkManagementDTO toWorkManagementDTO(WorkManagementEntity workManagementEntity){
        WorkManagementDTO workManagementDTO = modelMapper.map(workManagementEntity, WorkManagementDTO.class);
        return workManagementDTO;
    }
}
