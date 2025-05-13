package com.williams.will_ecommerce.auth.security.service;

import com.williams.will_ecommerce.auth.dto.UserResponse;
import com.williams.will_ecommerce.auth.entities.User;
import com.williams.will_ecommerce.auth.exception.RegisterException;
import com.williams.will_ecommerce.auth.repository.UserRepository;
import com.williams.will_ecommerce.auth.security.dto.JwtResponse;
import com.williams.will_ecommerce.auth.security.dto.LoginRequest;
import com.williams.will_ecommerce.auth.security.dto.MessageResponse;
import com.williams.will_ecommerce.auth.security.dto.RegisterRequest;
import com.williams.will_ecommerce.auth.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    JwtService jwtService;

    public JwtResponse login(LoginRequest authRequest) {

        // Autentificacion del usuario dentro de la base de datos a través del email
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(), authRequest.getPassword()
        );

        authenticationManager.authenticate(authToken);

        User user = userRepository.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserResponse userResponse = new UserResponse(user.getId(),user.getUsername(),user.getEmail(),user.getRole());

        String jwt = jwtService.generateToken(user, generateExtraClaims(user));

        return new JwtResponse(userResponse, jwt);

    }

    public ResponseEntity<MessageResponse> register(RegisterRequest authRequest) {

        // Check: email
        if (userRepository.existsByEmail(authRequest.getEmail())) {
            throw new RegisterException("Error: Email is already in use!");
        }

        // Create new user's account
        User user = new User(
                authRequest.getUsername(),
                authRequest.getEmail(),
                encoder.encode(authRequest.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getUsername());
        extraClaims.put("role", user.getRole().name());
        extraClaims.put("permissions", user.getAuthorities());

        return extraClaims;
    }
}
