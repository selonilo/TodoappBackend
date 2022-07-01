package com.cmv.borusan.model.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String username;
    private String password;
    private String email;
}
