package com.dudv.restaurant_management.api.admin;

import com.dudv.restaurant_management.model.request.admin.CreateScheduleRequest;
import com.dudv.restaurant_management.model.response.ResponseDTO;
import com.dudv.restaurant_management.service.WorkManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@Transactional
@RequestMapping("/admin/schedule")
public class sheduleAPI {
    @Autowired
    private WorkManagementService workManagementService;
    @PostMapping("/new")
    public ResponseDTO registration(@RequestBody CreateScheduleRequest createScheduleRequest) throws ParseException {
        return workManagementService.save(createScheduleRequest);
    }
}
