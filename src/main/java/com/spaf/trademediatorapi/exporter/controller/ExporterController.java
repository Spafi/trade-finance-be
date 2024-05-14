package com.spaf.trademediatorapi.exporter.controller;

import com.spaf.trademediatorapi.exporter.dto.ExporterDTO;
import com.spaf.trademediatorapi.exporter.service.ExporterService;
import com.spaf.trademediatorapi.transaction.dto.ExporterApprovedTransactionDTO;
import com.spaf.trademediatorapi.transaction.dto.ExporterRejectedTransactionDTO;
import com.spaf.trademediatorapi.transaction.dto.TransactionDTO;
import com.spaf.trademediatorapi.transaction.service.TradeMediatorFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.spaf.trademediatorapi.util.ApiPaths.EXPORTER_PATH;

@RestController
@RequiredArgsConstructor
@CrossOrigin( "*" )
@RequestMapping( EXPORTER_PATH )
public class ExporterController {

    private final ExporterService exporterService;
    private final TradeMediatorFacade tradeMediatorFacade;

    @GetMapping
    public ResponseEntity<List<ExporterDTO>> getAllExporters() {
        return ResponseEntity.ok( exporterService.findAll() );
    }

    @GetMapping( "{id}/transactions" )
    public ResponseEntity<List<TransactionDTO>> getExporterTransactions( @PathVariable UUID id ) {
        return ResponseEntity.ok( tradeMediatorFacade.getExporterCompletedTransactions( id ) );
    }

    @GetMapping( "{id}/transactions/updatable" )
    public ResponseEntity<List<TransactionDTO>> getExporterUpdatableTransactions( @PathVariable UUID id ) {
        return ResponseEntity.ok( tradeMediatorFacade.getExporterUpdatableTransactions( id ) );
    }

    @PostMapping( "approve-transaction" )
    public ResponseEntity<TransactionDTO> approveTransaction( @Valid @RequestBody ExporterApprovedTransactionDTO approvalRequest ) {
        return ResponseEntity.ok( tradeMediatorFacade.approveTransactionByExporter( approvalRequest ) );
    }

    @PostMapping( "reject-transaction" )
    public ResponseEntity<TransactionDTO> rejectTransaction( @Valid @RequestBody ExporterRejectedTransactionDTO rejectionRequest ) {
        return ResponseEntity.ok( tradeMediatorFacade.rejectTransactionByExporter( rejectionRequest ) );
    }


}