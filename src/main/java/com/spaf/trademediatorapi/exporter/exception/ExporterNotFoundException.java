package com.spaf.trademediatorapi.exporter.exception;

import com.spaf.trademediatorapi.core.exception.NotFoundException;

import java.text.MessageFormat;
import java.util.UUID;

public class ExporterNotFoundException extends NotFoundException {
    public ExporterNotFoundException( UUID id ) {
        super( MessageFormat.format( "Exporter with id {0} not found", id.toString() ) );

    }
}