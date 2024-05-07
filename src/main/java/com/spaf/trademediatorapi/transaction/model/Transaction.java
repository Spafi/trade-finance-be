package com.spaf.trademediatorapi.transaction.model;

import com.spaf.trademediatorapi.bank.model.Bank;
import com.spaf.trademediatorapi.core.model.BaseEntity;
import com.spaf.trademediatorapi.exporter.model.Exporter;
import com.spaf.trademediatorapi.importer.model.Importer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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

    @NotEmpty( message = "Transaction name must not be empty" )
    @Column( nullable = false )
    private String name;

    @Min( message = "Amount must be more than zero", value = 1 )
    @Positive
    @NotEmpty( message = "Amount unit must not be empty" )
    @Column( nullable = false )
    private Double amount;

    @NotEmpty( message = "Measuring unit must not be empty" )
    @Column( nullable = false )
    private String unit;

    @NotEmpty( message = "Good type must not be empty" )
    @Column( nullable = false )
    private String goodType;

    @Size( max = 2000 )
    @Column( length = 2000 )
    private String importerComments;

    @Size( max = 2000 )
    @Column( length = 2000 )
    private String exporterComments;

    @Enumerated( EnumType.STRING )
    @Column( nullable = false )
    private TransactionStatus status;

    private LocalDate tentativeDeliveryDate;

    private BigDecimal netPrice;

    private BigDecimal vat;

    @OneToOne
    private Importer importer;

    @OneToOne
    private Exporter exporter;

    @OneToOne
    private Bank bank;

}