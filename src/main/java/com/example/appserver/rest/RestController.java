package com.example.appserver.rest;

import com.example.appserver.dto.JwtDto;
import com.example.appserver.dto.ModuleDto;
import com.example.appserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/app/")
@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:63342")
@Slf4j
public class RestController {
    private final UserService userService;

    @Autowired
    public RestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("getModule")
    public ResponseEntity<ModuleDto> getUserObjectSID(@RequestBody JwtDto requestDto) {
        return userService.getModule(requestDto);
    }
}
