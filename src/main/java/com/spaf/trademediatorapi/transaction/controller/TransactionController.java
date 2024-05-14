package com.spaf.trademediatorapi.transaction.controller;

import com.spaf.trademediatorapi.transaction.dto.TransactionDTO;
import com.spaf.trademediatorapi.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.spaf.trademediatorapi.util.ApiPaths.TRANSACTION_PATH;

@RestController
@RequiredArgsConstructor
@CrossOrigin( "*" )
@RequestMapping( TRANSACTION_PATH )
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping( "{id}" )
    public ResponseEntity<TransactionDTO> getTransaction( @PathVariable UUID id ) {
        return ResponseEntity.ok( transactionService.findById( id )
                                                    .toDto() );
    }
}