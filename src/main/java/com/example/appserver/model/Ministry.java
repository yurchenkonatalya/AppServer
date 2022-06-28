package com.example.appserver.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "modules")
public class Ministry {
    @Id
    @Column(name="id_module")
    private Long idModule;

    @NotNull
    @Column(name="id_subsystem")
    private Long idSubsystem;

    @NotNull
    @Column(name="name_module")
    private String nameModule;
}
