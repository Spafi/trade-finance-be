package com.spaf.trademediatorapi.importer.repository;

import com.spaf.trademediatorapi.importer.model.Importer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImporterRepository extends JpaRepository<Importer, UUID> {
}