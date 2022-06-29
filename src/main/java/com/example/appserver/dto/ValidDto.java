package com.example.appserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValidDto {

    @JsonProperty("token")
    private String token;

    @JsonProperty("isValid")
    private Boolean isValid;
}
