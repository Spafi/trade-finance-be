package com.spaf.trademediatorapi.transaction.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
public record ExporterApprovedTransactionDTO(
        UUID transactionId,
        BigDecimal netPrice,
        LocalDate tentativeDeliveryDate,
        String comments
) {
}