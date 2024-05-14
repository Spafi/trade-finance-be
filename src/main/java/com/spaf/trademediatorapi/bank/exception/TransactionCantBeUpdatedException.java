package com.spaf.trademediatorapi.bank.exception;

import com.spaf.trademediatorapi.core.exception.BadRequestException;

import java.text.MessageFormat;
import java.util.UUID;

public class TransactionCantBeUpdatedException extends BadRequestException {
    public TransactionCantBeUpdatedException( UUID id ) {
        super( MessageFormat.format( "Transaction with id {0} cant be updated.",
                                     id.toString() ) );

    }
}