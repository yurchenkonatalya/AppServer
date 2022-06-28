package com.example.appserver.service;

import com.example.appserver.dto.JwtResponse;

public interface ApiService {
    JwtResponse checkAccessToken(String accessToken);
}
