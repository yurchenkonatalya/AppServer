package com.example.appserver.dao.impl;

import com.example.appserver.dao.ModuleDao;
import com.example.appserver.repositiry.ModuleRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ModuleDaoImpl implements ModuleDao {
    private final ModuleRepo moduleRepo;

    public ModuleDaoImpl(ModuleRepo moduleRepo) {
        this.moduleRepo = moduleRepo;
    }

    @Override
    public void addModule(Module module) {
        moduleRepo.save(module);
    }

    @Override
    public Optional<Module> getModuleById(Long idModule) {
        return moduleRepo.findById(idModule);
    }

    @Override
    public ArrayList<Module> getModulesByModuleName(String nameModule) {
        return moduleRepo.findModulesByNameModule(nameModule);
    }

    @Override
    public ArrayList<Module> getModulesByIdSubsystem(Long idSubsystem) {
        return moduleRepo.findModulesByIdSubsystem(idSubsystem);
    }

    @Override
    public void changeNameModule(Long idModule, String nameModule) {
        //TODO
    }
}
