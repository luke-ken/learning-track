package com.sideproject.learningtrack.controller;


import com.sideproject.learningtrack.dto.LoginRequest;
import com.sideproject.learningtrack.dto.LoginResponse;
import com.sideproject.learningtrack.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest request) {
        String token = userService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok().body(new LoginResponse(request.getUsername(), token));
    }
}
