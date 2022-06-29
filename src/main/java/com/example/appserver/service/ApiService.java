package com.example.appserver.service;

import com.example.appserver.dto.ValidDto;

public interface ApiService {
    ValidDto checkAccessToken(String accessToken);
}
