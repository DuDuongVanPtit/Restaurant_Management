package com.dudv.restaurant_management.controller.auth;

import com.dudv.restaurant_management.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(service.authenticate(authenticationRequest));
    }
}

//@RestController
//@RequestMapping("")
//@RequiredArgsConstructor
//public class AuthenticationController {
//    private final AuthenticationService service;
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> register(@Valid @ModelAttribute AuthenticationRequest authenticationRequest, HttpServletResponse response) {
//        AuthenticationResponse authResponse = service.authenticate(authenticationRequest);
//        ResponseCookie cookie = ResponseCookie.from("token", authResponse.getToken())
//                .httpOnly(true)
//                .secure(true)
//                .path("/")
//                .maxAge(7 * 24 * 60 * 60)  // 7 days
//                .build();
//        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
//        return ResponseEntity.ok(authResponse);
//    }
//}
