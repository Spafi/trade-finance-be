package com.spaf.trademediatorapi.transaction.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UpdateTransactionDTO(

        @NotNull( message = "Transaction id must not be null" )
        UUID id,

        @Min( message = "Amount must be more than zero", value = 1 )
        @Positive
        Double amount,

        @NotEmpty( message = "Measuring unit must not be empty" )
        String unit,

        @NotEmpty( message = "Good type must not be empty" )
        String goodType,

        @NotEmpty( message = "Receiving address must not be empty" )
        String receivingAddress,

        @Email
        String email,

        String phone,

        @Size( max = 2000 )
        String importerComments,

        @Size( max = 2000 )
        String bankComments,

        @Size( max = 2000 )
        String exporterComments
) {
}