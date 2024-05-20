package com.dudv.restaurant_management.api.admin;

import com.dudv.restaurant_management.model.response.ResponseDTO;
import com.dudv.restaurant_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/user")
public class UserAPI {
    @Autowired
    private UserService userService;
    @PostMapping("/active/{id}")
    public ResponseDTO disableActivity(@PathVariable Long id){
        return userService.active(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseDTO delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
