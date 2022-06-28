package com.example.appserver.service.impl;

import com.example.appserver.dto.JwtDto;
import com.example.appserver.dto.JwtResponse;
import com.example.appserver.dto.ModuleDto;
import com.example.appserver.model.Ministry;
import com.example.appserver.repositiry.MinistryRepo;
import com.example.appserver.service.ApiService;
import com.example.appserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final ApiService apiService;
    private final MinistryRepo ministryRepo;

    @Autowired
    public UserServiceImpl(ApiService apiService, MinistryRepo ministryRepoM) {
        this.apiService = apiService;
        this.ministryRepo = ministryRepoM;
    }

    @Override
    public ResponseEntity getUsersList(JwtDto jwtDto) {
        JwtResponse responseEntity = apiService.checkAccessToken(jwtDto.getToken());
        if (responseEntity.getIsValid()){
            ArrayList<Module> list = null;
            Map<Object, Object> response = new HashMap<>();
            for(int i = 0; i < list.size(); i++){
                response.put("module", list.get(i).getName());
            }
            return ResponseEntity.ok(response);
        }
        return null;
    }

    @Override
    public ResponseEntity<ModuleDto> getModule(JwtDto jwtDto) {
        JwtResponse response = apiService.checkAccessToken(jwtDto.getToken());
        log.error(response.toString());
        if(response.getIsValid()){
           Ministry ministry = ministryRepo.findModulesByIdSubsystem(1L);
           return new ResponseEntity<ModuleDto>(
                   new ModuleDto(ministry.getIdModule(), ministry.getIdSubsystem(), ministry.getNameModule()),
                   HttpStatus.OK);
        }
        return new ResponseEntity<ModuleDto>((ModuleDto) null, HttpStatus.FORBIDDEN);
    }
}
