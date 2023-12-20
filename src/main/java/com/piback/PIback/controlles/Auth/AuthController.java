package com.piback.PIback.controlles.Auth;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin({"*"})
@RequestMapping("/auth")

@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final AuthService authService;
    @Operation(summary = "Login service", description = "Loguea un usuario existente")
    @PostMapping(value="login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }
    @Operation(summary = "Register service", description = "Registra usuarios")
    @PostMapping(value="register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        System.out.println(request.email);
        return ResponseEntity.ok(authService.register(request));
    }
    
}
