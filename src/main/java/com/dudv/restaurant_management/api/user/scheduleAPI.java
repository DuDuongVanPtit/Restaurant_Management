package com.dudv.restaurant_management.api.user;


import com.dudv.restaurant_management.Utils.SecurityUtils;
import com.dudv.restaurant_management.model.request.ScheduleRegistrationRequest;
import com.dudv.restaurant_management.model.request.ScheduleRegistrationRequestWrapper;
import com.dudv.restaurant_management.model.response.ResponseDTO;
import com.dudv.restaurant_management.model.response.WorkManagementDTO;
import com.dudv.restaurant_management.service.WorkManagementService;
import com.dudv.restaurant_management.service.WorkScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/schedule")
public class scheduleAPI {
    @Autowired
    private WorkManagementService workManagementService;
    @Autowired
    private WorkScheduleService workScheduleService;
    @PostMapping("/registration")
    public ResponseDTO registration(@RequestBody ScheduleRegistrationRequestWrapper wrapper) throws ParseException {
        List<ScheduleRegistrationRequest> scheduleRegistrationRequests = wrapper.getScheduleRegistrationRequests();
        Long id = wrapper.getId();
        UserDetails user = null;
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            user = SecurityUtils.getPrincipal();
        }
//        ResponseDTO responseDTO = workScheduleService.save(scheduleRegistrationRequests, id, user.getUsername());
        System.out.println("ok");
        return new ResponseDTO();
    }
    @GetMapping("/workmanagement")
    public WorkManagementDTO getWorkManagement(@RequestParam String stringDate) throws ParseException {
        WorkManagementDTO workManagementDTO = workManagementService.findByStartDateAndEndDate(stringDate);
        return workManagementDTO;
    }
}
