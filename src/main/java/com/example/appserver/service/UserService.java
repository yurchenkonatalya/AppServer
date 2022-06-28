package com.example.appserver.service;

import com.example.appserver.dto.JwtDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity getUsersList(JwtDto jwtDto);
    ResponseEntity getModule(JwtDto jwtDto);
}
