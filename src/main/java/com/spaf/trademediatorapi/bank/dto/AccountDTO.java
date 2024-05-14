package com.spaf.trademediatorapi.bank.dto;

import com.spaf.trademediatorapi.bank.model.Account;
import lombok.Builder;

import java.util.UUID;

@Builder
public record AccountDTO(
        UUID id,
        String accountNumber
) {

    public Account toEntity() {
        return Account.builder()
                      .id( id )
                      .accountNumber( accountNumber )
                      .build();
    }
}