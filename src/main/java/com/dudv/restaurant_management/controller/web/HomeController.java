package com.dudv.restaurant_management.controller.web;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class HomeController {
    @GetMapping(value = "/home")
    public String home(Model model, Authentication authentication) {
//        if (authentication != null) {
//            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//            System.out.println("Authorities count: " + authorities.size());
//            for (GrantedAuthority authority : authorities) {
//                System.out.println("Authority: " + authority.getAuthority());
//            }
//            model.addAttribute("authorities", authorities);
//        }
        return "/home.html";
    }
}
