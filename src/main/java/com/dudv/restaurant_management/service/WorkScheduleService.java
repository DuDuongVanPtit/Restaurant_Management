package com.dudv.restaurant_management.service;

import com.dudv.restaurant_management.model.request.ScheduleRegistrationRequest;
import com.dudv.restaurant_management.model.response.ResponseDTO;

import java.text.ParseException;
import java.util.List;

public interface WorkScheduleService {
    ResponseDTO save(List<ScheduleRegistrationRequest> scheduleRegistrationRequests, Long WorkManagementId, String staffEmail) throws ParseException;

}
