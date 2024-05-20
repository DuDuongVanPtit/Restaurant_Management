package com.dudv.restaurant_management.service;

import com.dudv.restaurant_management.model.request.admin.CreateScheduleRequest;
import com.dudv.restaurant_management.model.response.ResponseDTO;
import com.dudv.restaurant_management.model.response.WorkManagementDTO;

import java.text.ParseException;

public interface WorkManagementService {
    ResponseDTO save(CreateScheduleRequest createScheduleRequest) throws ParseException;
    WorkManagementDTO findByStartDateAndEndDate(String stringDate) throws ParseException;
}
