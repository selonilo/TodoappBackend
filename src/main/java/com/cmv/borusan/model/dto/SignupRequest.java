package com.cmv.borusan.model.dto;

import lombok.Getter;

import java.util.Set;

@Getter
public class SignupRequest {
    private String username;

    private String email;

    private String nameSurname;

    private Set<String> role;

    private String password;
}
