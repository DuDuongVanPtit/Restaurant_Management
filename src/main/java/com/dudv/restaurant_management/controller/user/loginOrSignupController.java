package com.dudv.restaurant_management.controller.user;
import com.dudv.restaurant_management.controller.auth.AuthenticationRequest;
import com.dudv.restaurant_management.controller.auth.AuthenticationResponse;
import com.dudv.restaurant_management.controller.auth.RegisterRequest;
import com.dudv.restaurant_management.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.ParseException;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class loginOrSignupController {
    private final AuthenticationService service;
    @GetMapping(value = "/login")
    public String login(Model model){
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        model.addAttribute("authenticationRequest", authenticationRequest);
        return "/login.html";
    }
    @GetMapping(value = "/signup")
    public String signup(Model model){
        RegisterRequest registerRequest = new RegisterRequest();
        model.addAttribute("registerRequest", registerRequest);
        return "/signup.html";
    }
    @PostMapping("/account_verifications")
    public String register(@Valid @ModelAttribute RegisterRequest registerRequest, BindingResult bindingResult) throws ParseException {
        if(bindingResult.hasErrors()){
            return "/signup.html";
        }
        ResponseEntity.ok(service.register(registerRequest));
        return "redirect:/login";
    }
}
