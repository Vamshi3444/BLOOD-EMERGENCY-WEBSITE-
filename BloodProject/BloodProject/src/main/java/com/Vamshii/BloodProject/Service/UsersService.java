package com.Vamshii.BloodProject.Service;

import com.Vamshii.BloodProject.Model.Users;
import com.Vamshii.BloodProject.repository.RepositoryForUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class UsersService {
    @Autowired
    private final RepositoryForUsers repo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    public UsersService(RepositoryForUsers repo) {
        this.repo = repo;
    }

    public ResponseEntity<Map<String, String>> register(Users user) {
        Users u = repo.findByUserName(user.getUserName());

        try {
            if (u == null) {
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                repo.save(user);
                return ResponseEntity.ok(Collections.singletonMap("message", "Signup successful"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity
                .status(HttpStatus.CONFLICT) // 409 Conflict for existing user
                .body(Collections.singletonMap("message", "User already exists"));
    }

    public ResponseEntity<Map<String, String>> verify(Users user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));

            if (authentication.isAuthenticated()) {
                String token = jwtService.generateToken(user.getUserName());
                return ResponseEntity.ok(Collections.singletonMap("token", token));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("message", "Invalid username or password"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap("message", "Invalid username or password"));
    }
}