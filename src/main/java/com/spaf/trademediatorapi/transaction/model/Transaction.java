package com.spaf.trademediatorapi.transaction.model;

import com.spaf.trademediatorapi.bank.model.Account;
import com.spaf.trademediatorapi.bank.model.Bank;
import com.spaf.trademediatorapi.core.model.BaseEntity;
import com.spaf.trademediatorapi.exporter.model.Exporter;
import com.spaf.trademediatorapi.importer.model.Importer;
import com.spaf.trademediatorapi.transaction.dto.TransactionDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction extends BaseEntity {

    @Min( message = "Amount must be more than zero", value = 1 )
    @Positive
    @Column( nullable = false )
    private Double amount;

    @NotEmpty( message = "Measuring unit must not be empty" )
    @Column( nullable = false )
    private String unit;

    @NotEmpty( message = "Good type must not be empty" )
    @Column( nullable = false )
    private String goodType;

    @NotEmpty( message = "Receiving address must not be empty" )
    @Column( nullable = false )
    private String receivingAddress;

    @Size( max = 2000 )
    @Column( length = 2000 )
    private String importerComments;

    @Size( max = 2000 )
    @Column( length = 2000 )
    private String bankComments;

    @Size( max = 2000 )
    @Column( length = 2000 )
    private String exporterComments;

    @Enumerated( EnumType.STRING )
    @Column( nullable = false )
    private TransactionStatus status;

    private LocalDate tentativeDeliveryDate;

    private BigDecimal netPrice;

    private BigDecimal vat;

    @Email
    @Column
    private String email;

    @Column
    private String phone;

    @ManyToOne
    private Importer importer;

    @ManyToOne
    private Exporter exporter;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    private Account account;

    public TransactionDTO toDto() {
        return TransactionDTO.builder()
                             .id( id )
                             .amount( amount )
                             .unit( unit )
                             .goodType( goodType )
                             .receivingAddress( receivingAddress )
                             .phone( phone )
                             .email( email )
                             .importerComments( importerComments )
                             .bankComments( bankComments )
                             .exporterComments( exporterComments )
                             .status( status )
                             .tentativeDeliveryDate( tentativeDeliveryDate )
                             .netPrice( netPrice )
                             .vat( vat )
                             .importer( importer.toDto() )
                             .exporter( exporter.toDto() )
                             .bank( bank.toDto() )
                             .account( account.toDto() )
                             .createdAt( createdAt )
                             .build();
    }

    public boolean canBeUpdated() {
        return this.getStatus() == TransactionStatus.REJECTED_BY_BANK;
    }

}