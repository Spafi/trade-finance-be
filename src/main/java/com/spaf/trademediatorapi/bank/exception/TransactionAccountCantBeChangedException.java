package com.spaf.trademediatorapi.bank.exception;

import com.spaf.trademediatorapi.core.exception.BadRequestException;

import java.text.MessageFormat;
import java.util.UUID;

public class TransactionAccountCantBeChangedException extends BadRequestException {
    public TransactionAccountCantBeChangedException( UUID id ) {
        super( MessageFormat.format( "Transaction with id {0} is already approved. Account cant be changed.",
                                     id.toString() ) );

    }
}