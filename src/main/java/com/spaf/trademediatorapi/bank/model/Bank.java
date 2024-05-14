package com.spaf.trademediatorapi.bank.model;

import com.spaf.trademediatorapi.bank.dto.BankDTO;
import com.spaf.trademediatorapi.core.model.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.LinkedHashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Bank extends BaseEntity {

    @NotEmpty( message = "Bank name must not be empty" )
    private String name;

    @ToString.Exclude
    @OneToMany( mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<Account> accounts = new LinkedHashSet<>();

    public BankDTO toDto() {
        return BankDTO.builder()
                      .id( id )
                      .name( name )
                      .build();
    }

}