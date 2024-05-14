package com.spaf.trademediatorapi.importer.repository;

import com.spaf.trademediatorapi.importer.model.Importer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImporterRepository extends JpaRepository<Importer, UUID> {
}