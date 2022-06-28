package com.example.appserver.dto;

import com.example.appserver.model.Ministry;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ModuleListDto {

    private List<Ministry> ministryList;

}
