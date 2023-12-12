package com.piback.PIback.controlles.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.piback.PIback.models.User;
import com.piback.PIback.JWT.JWTService;
import com.piback.PIback.models.Role;
import com.piback.PIback.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final JWTService jwtService;
    //private final PasswordEncoder passwordEncoder;
    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request)
    
    {
       return (null);
        /*authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.findByUsername(), request.getPassword()));
    UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
    String token = jwtService.getToken(user);
    return AuthResponse.builder().token(token)
    .build();*/
    }
   
    //Registro de Usuario
    public AuthResponse register(RegisterRequest request)
    {
        System.out.println(request);

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);
        ;
       /*User user = User.builder()
       .username(request.getUsername())
       .email(request.getEmail())
       .password(request.getPassword())
       .role(Role.USER)
       .build();*/

       System.out.println(user);

       userRepository.save(user);

       return AuthResponse.builder()
       .token(jwtService.getToken(user))
       .build();
    }
}
