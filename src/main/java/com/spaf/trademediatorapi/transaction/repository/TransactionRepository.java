package com.spaf.trademediatorapi.transaction.repository;

import com.spaf.trademediatorapi.importer.model.Importer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Importer, UUID> {
}