package com.spaf.trademediatorapi.core.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler( Exception.class )
    @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
    public ResponseEntity<?> handleGenericException( BaseException exception, WebRequest request ) {
        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                         "Internal Server Error",
                                                         exception.getMessage() );

        return new ResponseEntity<>( errorResponse, HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @ExceptionHandler( NotFoundException.class )
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public ResponseEntity<?> handleNotFoundException( NotFoundException exception, WebRequest request ) {
        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.NOT_FOUND.value(),
                                                         "Not Found",
                                                         exception.getMessage() );

        return new ResponseEntity<>( errorResponse, HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler( BadRequestException.class )
    @ResponseStatus( HttpStatus.BAD_REQUEST )
    public ResponseEntity<?> handleBadRequestException( BadRequestException exception, WebRequest request ) {
        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.BAD_REQUEST.value(),
                                                         "Bad Request",
                                                         exception.getMessage() );

        return new ResponseEntity<>( errorResponse, HttpStatus.BAD_REQUEST );
    }

}