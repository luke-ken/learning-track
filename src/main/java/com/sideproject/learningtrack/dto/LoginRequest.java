package com.sideproject.learningtrack.dto;

import lombok.Value;

@Value
public class LoginRequest {
    String username, password;
}
