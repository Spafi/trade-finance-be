package com.spaf.trademediatorapi.exporter.repository;

import com.spaf.trademediatorapi.exporter.model.Exporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExporterRepository extends JpaRepository<Exporter, UUID> {
}