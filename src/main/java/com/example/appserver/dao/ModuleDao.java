package com.example.appserver.dao;

import java.util.ArrayList;
import java.util.Optional;

public interface ModuleDao {
    void addModule(Module module);
    Optional<Module> getModuleById(Long idModule);
    ArrayList<Module> getModulesByModuleName(String nameModule);
    ArrayList<Module> getModulesByIdSubsystem(Long idSubsystem);
    void changeNameModule (Long idModule, String nameModule);
}
