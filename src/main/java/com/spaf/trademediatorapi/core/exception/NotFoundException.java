package com.spaf.trademediatorapi.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class NotFoundException extends BaseException {
    protected NotFoundException( String message ) {
        super( message );
    }

}