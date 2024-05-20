package com.dudv.restaurant_management.controller.staff;


import com.dudv.restaurant_management.model.response.WorkManagementDTO;
import com.dudv.restaurant_management.service.WorkManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffHomeController {
    @Autowired
    private WorkManagementService workManagementService;
    @GetMapping(value = "/staff/home")
    public String homeAuthenticated(){
        return "/staff/staffHome.html";
    }
    @GetMapping(value = "/staff/schedule-registration")
    public String scheduleRegistration(){
//        WorkManagementDTO workManagementDTO = workManagementService.findByStartDateAndEndDate("ok");
        return "/staff/scheduleRegistration.html";
    }

}
