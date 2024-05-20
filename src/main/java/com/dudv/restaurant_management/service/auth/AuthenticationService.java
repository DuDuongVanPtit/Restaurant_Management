package com.dudv.restaurant_management.service.auth;

import com.dudv.restaurant_management.Utils.DateUtils;
import com.dudv.restaurant_management.config.JwtService;
import com.dudv.restaurant_management.controller.auth.AuthenticationRequest;
import com.dudv.restaurant_management.controller.auth.AuthenticationResponse;
import com.dudv.restaurant_management.controller.auth.RegisterRequest;
import com.dudv.restaurant_management.entity.Role;
import com.dudv.restaurant_management.entity.UserEntity;
import com.dudv.restaurant_management.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private DateUtils dateUtils;

    public AuthenticationResponse register(RegisterRequest request) throws ParseException {
        Date date = null;
        if(request.getBirthday() != null && request.getBirthday().trim() != ""){
            date = dateUtils.getDate(request.getBirthday());
        }
        var user = UserEntity.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .avatar(request.getAvatar())
                .gender(request.getGender())
                .address(request.getAddress())
                .phone(request.getPhone())
                .birthday(date)
                .role(Role.STAFF)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByStatusAndEmail(1, request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
