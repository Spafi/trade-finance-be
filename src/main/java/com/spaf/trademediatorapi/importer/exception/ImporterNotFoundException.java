package com.spaf.trademediatorapi.importer.exception;

import com.spaf.trademediatorapi.core.exception.NotFoundException;

import java.text.MessageFormat;
import java.util.UUID;

public class ImporterNotFoundException extends NotFoundException {
    public ImporterNotFoundException( UUID id ) {
        super( MessageFormat.format( "Importer with id {0} not found", id.toString() ) );

    }
}