package com.medo.backend.auth.service.impl;

import com.medo.backend.auth.dto.AuthRequest;
import com.medo.backend.auth.dto.AuthResponse;
import com.medo.backend.auth.dto.CreateUserDTO;
import com.medo.backend.auth.repository.AuthRepository;
import com.medo.backend.auth.security.JwtService;
import com.medo.backend.auth.service.AuthService;
import com.medo.backend.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Autowired
    public AuthServiceImpl(AuthRepository authRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public ResponseEntity<AuthResponse> createAccount(CreateUserDTO request) {
        if (authRepository.existsByName(request.getName()) || authRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body(new AuthResponse("user already exist ", null, null));
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setBio(request.getBio());
        user.setCompetences(request.getCompetences());
        user.setAvatarUrl(request.getAvatarUrl());

        authRepository.save(user);

        String jwt = jwtService.generateJwtToken(request.getEmail());

        return ResponseEntity.ok(AuthResponse.builder()
                .token(jwt)
                .username(request.getName())
                .message("Created account successfully")
                .build()
        );
    }

    @Override
    public ResponseEntity<AuthResponse> login(AuthRequest authRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateJwtToken(authRequest.getEmail());
        User user = authRepository.findByEmail(authRequest.getEmail()).orElseThrow();


        return ResponseEntity.ok(AuthResponse.builder()
                .token(jwt)
                .username(user.getName())
                .message("login successfully")
                .build());
    }
}
