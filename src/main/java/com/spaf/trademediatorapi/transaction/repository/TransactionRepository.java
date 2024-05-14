package com.spaf.trademediatorapi.transaction.repository;

import com.spaf.trademediatorapi.transaction.model.Transaction;
import com.spaf.trademediatorapi.transaction.model.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    Set<Transaction> findAllByImporterId( UUID importerId );

    Set<Transaction> findAllByImporterIdAndStatus( UUID importerId, TransactionStatus status );

    Set<Transaction> findAllByBankId( UUID bankId );

    Set<Transaction> findAllByBankIdAndStatusIn( UUID bank_id, Collection<TransactionStatus> status );

    Set<Transaction> findAllByExporterIdAndStatus( UUID exporterId, TransactionStatus status );

    Set<Transaction> findAllByStatus( TransactionStatus status );

}