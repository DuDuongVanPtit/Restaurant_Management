package com.dudv.restaurant_management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController {
    @GetMapping(value = "/admin/home")
    public String homeAuthenticated(){
        return "/admin/adminHome.html";
    }
}
