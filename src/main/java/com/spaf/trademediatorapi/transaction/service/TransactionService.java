package com.spaf.trademediatorapi.transaction.service;

import com.spaf.trademediatorapi.transaction.dto.TransactionDTO;
import com.spaf.trademediatorapi.transaction.exception.TransactionNotFoundException;
import com.spaf.trademediatorapi.transaction.model.Transaction;
import com.spaf.trademediatorapi.transaction.model.TransactionStatus;
import com.spaf.trademediatorapi.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Transaction findById( UUID transactionId ) {
        return transactionRepository.findById( transactionId )
                                    .orElseThrow( () -> new TransactionNotFoundException( transactionId ) );
    }

    public List<TransactionDTO> findAllByImporterId( UUID importerId ) {
        return transactionRepository.findAllByImporterId( importerId )
                                    .stream()
                                    .map( Transaction::toDto )
                                    .toList();
    }

    public List<TransactionDTO> findAllUpdatableByImporterId( UUID importerId ) {
        return transactionRepository.findAllByImporterIdAndStatus( importerId, TransactionStatus.REJECTED_BY_BANK )
                                    .stream()
                                    .map( Transaction::toDto )
                                    .toList();
    }

    public List<TransactionDTO> findAllByBankId( UUID bankId ) {
        return transactionRepository.findAllByBankId( bankId )
                                    .stream()
                                    .map( Transaction::toDto )
                                    .toList();
    }

    public List<TransactionDTO> findAllBankUpdatable( UUID bankId ) {
        List<TransactionStatus> bankUpdatableStatuses = Arrays.asList( TransactionStatus.REQUESTED,
                                                                       TransactionStatus.REJECTED_BY_EXPORTER );
        return transactionRepository.findAllByBankIdAndStatusIn( bankId, bankUpdatableStatuses )
                                    .stream()
                                    .map( Transaction::toDto )
                                    .toList();
    }

    public List<TransactionDTO> findAllBankApprovedByExporterId( UUID exporterId ) {
        return transactionRepository.findAllByExporterIdAndStatus( exporterId, TransactionStatus.APPROVED_BY_BANK )
                                    .stream()
                                    .map( Transaction::toDto )
                                    .toList();
    }

    public List<TransactionDTO> findAllExporterApprovedByExporterId( UUID exporterId ) {
        return transactionRepository.findAllByExporterIdAndStatus( exporterId, TransactionStatus.APPROVED_BY_EXPORTER )
                                    .stream()
                                    .map( Transaction::toDto )
                                    .toList();
    }

    public TransactionDTO save( Transaction transaction ) {
        return transactionRepository.save( transaction )
                                    .toDto();
    }


}