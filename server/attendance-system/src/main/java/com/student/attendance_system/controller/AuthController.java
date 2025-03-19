package com.student.attendance_system.controller;

import com.student.attendance_system.dtos.AuthRequest;
import com.student.attendance_system.dtos.AuthResponse;
import com.student.attendance_system.utils.JWTUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody AuthRequest request) {
    if (isValidUser(request.getUsername(), request.getPassword())) {
      String token = JWTUtil.generateToken(request.getUsername());
      return ResponseEntity.ok(new AuthResponse(token));
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
  }

  private boolean isValidUser(String username, String password) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(
            getClass().getClassLoader().getResourceAsStream("credentials.txt"))))) {
      return reader.lines().anyMatch(line -> {
        String[] parts = line.split(",");
        return parts.length == 2 && parts[0].equals(username) && parts[1].equals(password);
      });
    } catch (Exception e) {
      return false;
    }
  }
}
