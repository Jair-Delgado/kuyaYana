package com.piback.PIback.controlles.Auth;

import lombok.Data;

@Data


public class RegisterRequest {
    String username;
    String email;
    String password;
}
