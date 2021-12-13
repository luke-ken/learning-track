package com.sideproject.learningtrack.dto;

import lombok.Value;

@Value
public class LoginResponse {
    String username, token;
}
