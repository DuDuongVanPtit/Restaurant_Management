package com.dudv.restaurant_management.controller.admin;

import com.dudv.restaurant_management.model.user.UserResponseDTO;
import com.dudv.restaurant_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/staff-list")
    String staffList(Model model){
        List<UserResponseDTO> userResponseDTOS = userService.findAll();
        model.addAttribute("staffList", userResponseDTOS);
        return "/admin/staffList.html";
    }

    @GetMapping(value = "/manager-list")
    String managerList(Model model){
        List<UserResponseDTO> userResponseDTOS = userService.findAll();
        model.addAttribute("staffList", userResponseDTOS);
        return "/admin/managerList.html";
    }

    @GetMapping(value = "/staff-schedule")
    String staffSchedule(Model model){
        List<UserResponseDTO> userResponseDTOS = userService.findAll();

//        model.addAttribute("staffList", userResponseDTOS);
        return "/admin/staffSchedule.html";
    }

    @GetMapping(value = "/schedule")
    String createSchedule(Model model){
//        List<UserResponseDTO> userResponseDTOS = userService.findAll();
//        model.addAttribute("staffList", userResponseDTOS);
        return "/admin/createSchedule.html";
    }
}
