package com.spaf.trademediatorapi.transaction.dto;

import com.spaf.trademediatorapi.bank.dto.AccountDTO;
import com.spaf.trademediatorapi.bank.dto.BankDTO;
import com.spaf.trademediatorapi.exporter.dto.ExporterDTO;
import com.spaf.trademediatorapi.importer.dto.ImporterDTO;
import com.spaf.trademediatorapi.transaction.model.Transaction;
import com.spaf.trademediatorapi.transaction.model.TransactionStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record TransactionDTO(
        UUID id,
        Double amount,
        String unit,
        String goodType,

        @NotEmpty( message = "Receiving address must not be empty" )
        String receivingAddress,

        @Email
        String email,
        String phone,
        String importerComments,
        String bankComments,
        String exporterComments,
        TransactionStatus status,
        LocalDate tentativeDeliveryDate,
        BigDecimal netPrice,
        BigDecimal vat,
        ImporterDTO importer,
        ExporterDTO exporter,
        BankDTO bank,
        AccountDTO account,
        LocalDateTime createdAt
) {

    public Transaction toEntity() {
        return Transaction.builder()
                          .id( id )
                          .createdAt( createdAt )
                          .importer( importer.toEntity() )
                          .exporter( exporter.toEntity() )
                          .amount( amount )
                          .unit( unit )
                          .goodType( goodType )
                          .receivingAddress( receivingAddress )
                          .email( email )
                          .phone( phone )
                          .importerComments( importerComments )
                          .bankComments( bankComments )
                          .exporterComments( exporterComments )
                          .status( status )
                          .tentativeDeliveryDate( tentativeDeliveryDate )
                          .netPrice( netPrice )
                          .vat( vat )
                          .bank( bank.toEntity() )
                          .account( account.toEntity() )
                          .build();
    }
}