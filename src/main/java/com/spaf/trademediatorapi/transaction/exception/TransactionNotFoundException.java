package com.spaf.trademediatorapi.transaction.exception;

import com.spaf.trademediatorapi.core.exception.BaseException;

import java.text.MessageFormat;
import java.util.UUID;

public class TransactionNotFoundException extends BaseException {
    public TransactionNotFoundException( UUID id ) {
        super( MessageFormat.format( "Transaction with id {0} not found", id.toString() ) );

    }
}