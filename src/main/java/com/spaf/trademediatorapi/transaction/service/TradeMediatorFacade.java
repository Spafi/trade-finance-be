package com.spaf.trademediatorapi.transaction.service;

import com.spaf.trademediatorapi.bank.exception.TransactionCantBeUpdatedException;
import com.spaf.trademediatorapi.bank.model.Account;
import com.spaf.trademediatorapi.bank.model.Bank;
import com.spaf.trademediatorapi.bank.service.BankService;
import com.spaf.trademediatorapi.exporter.model.Exporter;
import com.spaf.trademediatorapi.exporter.service.ExporterService;
import com.spaf.trademediatorapi.importer.model.Importer;
import com.spaf.trademediatorapi.importer.service.ImporterService;
import com.spaf.trademediatorapi.transaction.dto.*;
import com.spaf.trademediatorapi.transaction.model.Transaction;
import com.spaf.trademediatorapi.transaction.model.TransactionStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TradeMediatorFacade {

    private final TransactionService transactionService;
    private final ImporterService importerService;
    private final ExporterService exporterService;
    private final BankService bankService;

    public List<TransactionDTO> getImporterTransactions( UUID importerId ) {

        Importer importer = importerService.findById( importerId );

        return transactionService.findAllByImporterId( importer.getId() );
    }

    public List<TransactionDTO> getImporterUpdatableTransactions( UUID importerId ) {

        Importer importer = importerService.findById( importerId );

        return transactionService.findAllUpdatableByImporterId( importer.getId() );
    }


    public List<TransactionDTO> getBankTransactions( UUID bankId ) {

        Bank bank = bankService.findById( bankId );

        return transactionService.findAllByBankId( bank.getId() );
    }

    public List<TransactionDTO> getBankUpdatableTransactions( UUID bankId ) {

        Bank bank = bankService.findById( bankId );

        return transactionService.findAllBankUpdatable( bank.getId() );
    }

    public List<TransactionDTO> getExporterUpdatableTransactions( UUID exporterId ) {

        Exporter exporter = exporterService.findById( exporterId );

        return transactionService.findAllBankApprovedByExporterId( exporter.getId() );
    }

    public List<TransactionDTO> getExporterCompletedTransactions( UUID exporterId ) {

        Exporter exporter = exporterService.findById( exporterId );

        return transactionService.findAllExporterApprovedByExporterId( exporter.getId() );
    }

    public TransactionDTO approveTransactionByBank( BankApprovedTransactionDTO approvalRequest ) {

        Transaction transaction = transactionService.findById( approvalRequest.transactionId() );
        Account account = bankService.findBankAccount( approvalRequest.accountId() );

        transaction.setStatus( TransactionStatus.APPROVED_BY_BANK );
        transaction.setBankComments( approvalRequest.comments() );
        transaction.setAccount( account );

        return transactionService.save( transaction );
    }

    public TransactionDTO rejectTransactionByBank( BankRejectedTransactionDTO rejectionRequest ) {

        Transaction transaction = transactionService.findById( rejectionRequest.transactionId() );
        transaction.setStatus( TransactionStatus.REJECTED_BY_BANK );
        transaction.setBankComments( rejectionRequest.comments() );

        return transactionService.save( transaction );
    }

    public TransactionDTO approveTransactionByExporter( ExporterApprovedTransactionDTO approvalRequest ) {

        Transaction transaction = transactionService.findById( approvalRequest.transactionId() );
        transaction.setStatus( TransactionStatus.APPROVED_BY_EXPORTER );
        transaction.setNetPrice( approvalRequest.netPrice() );
        transaction.setTentativeDeliveryDate( approvalRequest.tentativeDeliveryDate() );
        transaction.setExporterComments( approvalRequest.comments() );

        return transactionService.save( transaction );
    }

    public TransactionDTO rejectTransactionByExporter( @Valid ExporterRejectedTransactionDTO rejectionRequest ) {

        Transaction transaction = transactionService.findById( rejectionRequest.transactionId() );
        transaction.setStatus( TransactionStatus.REJECTED_BY_EXPORTER );
        transaction.setExporterComments( rejectionRequest.comments() );

        return transactionService.save( transaction );
    }


    public TransactionDTO create( CreateTransactionDTO createTransactionDTO ) {

        Importer importer = importerService.findById( createTransactionDTO.importerId() );
        Exporter exporter = exporterService.findById( createTransactionDTO.exporterId() );
        Bank bank = bankService.findById( createTransactionDTO.bankId() );
        Account account = bankService.findBankAccount( createTransactionDTO.accountId() );

        Transaction transaction = Transaction.builder()
                                             .importer( importer )
                                             .exporter( exporter )
                                             .bank( bank )
                                             .account( account )
                                             .receivingAddress( createTransactionDTO.receivingAddress() )
                                             .amount( createTransactionDTO.amount() )
                                             .unit( createTransactionDTO.unit() )
                                             .goodType( createTransactionDTO.goodType() )
                                             .importerComments( createTransactionDTO.importerComments() )
                                             .status( TransactionStatus.REQUESTED )
                                             .build();

        return transactionService.save( transaction );
    }


    public TransactionDTO update( UpdateTransactionDTO updateTransactionDTO ) {

        Transaction transaction = transactionService.findById( updateTransactionDTO.id() );

        if ( !transaction.canBeUpdated() ) {
            throw new TransactionCantBeUpdatedException( transaction.getId() );
        }

        transaction.setAmount( updateTransactionDTO.amount() );
        transaction.setUnit( updateTransactionDTO.unit() );
        transaction.setGoodType( updateTransactionDTO.goodType() );
        transaction.setReceivingAddress( updateTransactionDTO.receivingAddress() );
        transaction.setEmail( updateTransactionDTO.email() );
        transaction.setPhone( updateTransactionDTO.phone() );
        transaction.setImporterComments( updateTransactionDTO.importerComments() );
        transaction.setBankComments( updateTransactionDTO.bankComments() );
        transaction.setExporterComments( updateTransactionDTO.exporterComments() );
        transaction.setStatus( TransactionStatus.REQUESTED );

        return transactionService.save( transaction );
    }

}