package com.spaf.trademediatorapi.transaction.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record BankApprovedTransactionDTO(
        UUID transactionId,
        UUID accountId,
        String comments
) {
}