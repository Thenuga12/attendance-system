package com.student.attendance_system.security;

import com.student.attendance_system.utils.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.filter.GenericFilterBean;

public class JWTFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String authHeader = httpRequest.getHeader("Authorization");

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header");
      return;
    }

    String token = authHeader.substring(7);
    String username = JWTUtil.validateToken(token);

    if (username == null) {
      ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
      return;
    }

    chain.doFilter(request, response);
  }
}
