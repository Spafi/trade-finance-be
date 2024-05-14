package com.spaf.trademediatorapi.bank.dto;

import com.spaf.trademediatorapi.bank.model.Bank;
import lombok.Builder;

import java.util.UUID;

@Builder
public record BankDTO(
        UUID id,
        String name
) {

    public Bank toEntity() {
        return Bank.builder()
                   .id( id )
                   .name( name )
                   .build();
    }
}