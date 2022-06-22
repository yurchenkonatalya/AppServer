package com.example.appserver.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "modules")
public class Module {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_module")
    private Long id_module;

    @NotNull
    @Column(name="id_subsystem")
    private Long id_subsystem;

    @NotNull
    @Column(name="name_module")
    private String name_module;
}
