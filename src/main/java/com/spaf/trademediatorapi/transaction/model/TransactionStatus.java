package com.spaf.trademediatorapi.transaction.model;

public enum TransactionStatus {
    REQUESTED,
    REJECTED_BY_BANK,
    APPROVED_BY_BANK,
    REJECTED_BY_EXPORTER,
    APPROVED_BY_EXPORTER
}