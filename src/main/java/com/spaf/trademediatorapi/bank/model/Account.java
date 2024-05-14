package com.spaf.trademediatorapi.bank.model;

import com.spaf.trademediatorapi.bank.dto.AccountDTO;
import com.spaf.trademediatorapi.core.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@ToString
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Account extends BaseEntity {

    @Column( unique = true )
    @NotEmpty( message = "Account number must not be empty" )
    private String accountNumber;


    @ManyToOne
    @JoinColumn( name = "bank_id" )
    private Bank bank;

    public AccountDTO toDto() {
        return AccountDTO.builder()
                         .id( id )
                         .accountNumber( accountNumber )
                         .build();
    }

}