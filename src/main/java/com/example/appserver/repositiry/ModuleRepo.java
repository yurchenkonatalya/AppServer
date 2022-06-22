package com.example.appserver.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ModuleRepo extends JpaRepository<Module, Long> {
    ArrayList<Module> findModulesByNameModule(String nameModule);
    ArrayList<Module> findModulesByIdSubsystem(Long idSubsystem);

}
