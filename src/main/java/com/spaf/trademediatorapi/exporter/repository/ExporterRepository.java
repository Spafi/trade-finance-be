package com.spaf.trademediatorapi.exporter.repository;

import com.spaf.trademediatorapi.exporter.model.Exporter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExporterRepository extends JpaRepository<Exporter, UUID> {
}