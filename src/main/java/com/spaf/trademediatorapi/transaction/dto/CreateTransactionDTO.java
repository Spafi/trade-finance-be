package com.spaf.trademediatorapi.transaction.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateTransactionDTO(

        @Min( message = "Amount must be more than zero", value = 1 )
        @NotNull
        @Positive
        Double amount,

        @NotEmpty( message = "Measuring unit must not be empty" )
        @NotNull
        String unit,

        @NotEmpty( message = "Good type must not be empty" )
        @NotNull
        String goodType,

        @NotEmpty( message = "Receiving address must not be empty" )
        String receivingAddress,

        @Email
        String email,

        String phone,

        @Size( max = 2000 )
        String importerComments,

        @NotNull( message = "Importer id must not be null" )
        UUID importerId,

        @NotNull( message = "Bank id must not be null" )
        UUID bankId,

        @NotNull( message = "Exporter id must not be null" )
        UUID exporterId,

        @NotNull( message = "Bank account id must not be null" )
        UUID accountId
) {
}