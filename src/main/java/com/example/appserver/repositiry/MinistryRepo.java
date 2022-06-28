package com.example.appserver.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appserver.model.Ministry;

public interface MinistryRepo extends JpaRepository<Ministry, Long> {
    Ministry findModulesByNameModule(String nameModule);
    Ministry findModulesByIdSubsystem(Long idSubsystem);
}
