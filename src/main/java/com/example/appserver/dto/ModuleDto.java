package com.example.appserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModuleDto {
    private Long idModule;
    private Long idSubsystem;
    private String nameModule;
}
