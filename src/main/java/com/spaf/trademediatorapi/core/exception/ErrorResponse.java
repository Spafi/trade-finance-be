package com.spaf.trademediatorapi.core.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class ErrorResponse {
    private int status;
    private LocalDateTime timestamp;
    private String error;
    private String message;

    public ErrorResponse( int status,
                          String error,
                          String message
    ) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
    }

}