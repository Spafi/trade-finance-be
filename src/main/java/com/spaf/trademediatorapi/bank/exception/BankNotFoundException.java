package com.spaf.trademediatorapi.bank.exception;

import com.spaf.trademediatorapi.core.exception.NotFoundException;

import java.text.MessageFormat;
import java.util.UUID;

public class BankNotFoundException extends NotFoundException {
    public BankNotFoundException( UUID id ) {
        super( MessageFormat.format( "Bank with id {0} not found", id.toString() ) );

    }
}