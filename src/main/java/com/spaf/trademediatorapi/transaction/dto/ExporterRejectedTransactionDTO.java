package com.spaf.trademediatorapi.transaction.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ExporterRejectedTransactionDTO(
        UUID transactionId,
        String comments
) {
}