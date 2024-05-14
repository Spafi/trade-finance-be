package com.spaf.trademediatorapi.importer.controller;

import com.spaf.trademediatorapi.importer.dto.ImporterDTO;
import com.spaf.trademediatorapi.importer.service.ImporterService;
import com.spaf.trademediatorapi.transaction.dto.CreateTransactionDTO;
import com.spaf.trademediatorapi.transaction.dto.TransactionDTO;
import com.spaf.trademediatorapi.transaction.dto.UpdateTransactionDTO;
import com.spaf.trademediatorapi.transaction.service.TradeMediatorFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.spaf.trademediatorapi.util.ApiPaths.IMPORTER_PATH;

@RestController
@RequiredArgsConstructor
@CrossOrigin( "*" )
@RequestMapping( IMPORTER_PATH )
public class ImporterController {

    private final ImporterService importerService;
    private final TradeMediatorFacade tradeMediatorFacade;

    @GetMapping
    @Operation( summary = "Get all importers" )
    @ApiResponse( responseCode = "200", description = "Got importer list",
            content = { @Content( schema = @Schema( implementation = ImporterDTO.class ) ) } )
    public ResponseEntity<List<ImporterDTO>> getAllImporters() {
        return ResponseEntity.ok( importerService.findAll() );
    }

    @GetMapping( "{id}/transactions" )
    @Operation( summary = "Get importer transactions by importer id" )
    @ApiResponses( value = {
            @ApiResponse( responseCode = "200", description = "Got importer transactions",
                    content = { @Content( schema = @Schema( implementation = TransactionDTO.class ) ) } ),
            @ApiResponse( responseCode = "404", description = "Importer not found" ) } )
    public ResponseEntity<List<TransactionDTO>> getImporterTransactions( @PathVariable UUID id ) {
        return ResponseEntity.ok( tradeMediatorFacade.getImporterTransactions( id ) );
    }

    @GetMapping( "{id}/transactions/updatable" )
    @Operation( summary = "Get importer updatable transactions by importer id" )
    @ApiResponses( value = {
            @ApiResponse( responseCode = "200", description = "Got importer updatable transactions",
                    content = { @Content( schema = @Schema( implementation = TransactionDTO.class ) ) } ),
            @ApiResponse( responseCode = "404", description = "Importer not found" ) } )
    public ResponseEntity<List<TransactionDTO>> getImporterUpdatableTransactions( @PathVariable UUID id ) {
        return ResponseEntity.ok( tradeMediatorFacade.getImporterUpdatableTransactions( id ) );
    }

    @PostMapping( "request-transaction" )
    @Operation( summary = "Request a new transaction" )
    @ApiResponses( value = {
            @ApiResponse( responseCode = "201", description = "Transaction created",
                    content = { @Content( schema = @Schema( implementation = TransactionDTO.class ) ) } ),
            @ApiResponse( responseCode = "400", description = "Invalid input" )
    } )
    public ResponseEntity<TransactionDTO> requestTransaction( @Valid @RequestBody CreateTransactionDTO transaction ) {
        return new ResponseEntity<>( tradeMediatorFacade.create( transaction ), HttpStatus.CREATED );
    }

    @PutMapping( "update-transaction" )
    @Operation( summary = "Update an existing transaction" )
    @ApiResponses( value = {
            @ApiResponse( responseCode = "200", description = "Transaction updated",
                    content = { @Content( schema = @Schema( implementation = TransactionDTO.class ) ) } ),
            @ApiResponse( responseCode = "400", description = "Invalid input" ),
            @ApiResponse( responseCode = "404", description = "Transaction not found" )
    } )
    public ResponseEntity<TransactionDTO> updateTransaction( @Valid @RequestBody UpdateTransactionDTO transaction ) {
        return ResponseEntity.ok( tradeMediatorFacade.update( transaction ) );
    }

}