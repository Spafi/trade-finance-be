package com.spaf.trademediatorapi.bank.exception;

import com.spaf.trademediatorapi.core.exception.NotFoundException;

import java.text.MessageFormat;
import java.util.UUID;

public class AccountNotFoundException extends NotFoundException {
    public AccountNotFoundException( UUID id ) {
        super( MessageFormat.format( "Account with id {0} not found", id.toString() ) );

    }
}