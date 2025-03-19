package com.student.attendance_system.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

  private String username;
  private String password;
}
