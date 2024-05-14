package com.spaf.trademediatorapi.bank.controller;

import com.spaf.trademediatorapi.bank.dto.AccountDTO;
import com.spaf.trademediatorapi.bank.dto.BankDTO;
import com.spaf.trademediatorapi.bank.service.BankService;
import com.spaf.trademediatorapi.transaction.dto.BankApprovedTransactionDTO;
import com.spaf.trademediatorapi.transaction.dto.BankRejectedTransactionDTO;
import com.spaf.trademediatorapi.transaction.dto.TransactionDTO;
import com.spaf.trademediatorapi.transaction.service.TradeMediatorFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.spaf.trademediatorapi.util.ApiPaths.BANK_PATH;

@RestController
@RequiredArgsConstructor
@CrossOrigin( "*" )
@RequestMapping( BANK_PATH )
public class BankController {

    private final BankService bankService;
    private final TradeMediatorFacade tradeMediatorFacade;

    @GetMapping
    public ResponseEntity<List<BankDTO>> getAllBanks() {
        return ResponseEntity.ok( bankService.findAll() );
    }

    @GetMapping( "{id}/accounts" )
    public ResponseEntity<List<AccountDTO>> getBankAccounts( @PathVariable UUID id ) {
        return ResponseEntity.ok( bankService.findBankAccounts( id ) );
    }

    @GetMapping( "{id}/transactions" )
    public ResponseEntity<List<TransactionDTO>> getBankTransactions( @PathVariable UUID id ) {
        return ResponseEntity.ok( tradeMediatorFacade.getBankTransactions( id ) );
    }

    @GetMapping( "{id}/transactions/updatable" )
    public ResponseEntity<List<TransactionDTO>> getBankUpdatableTransactions( @PathVariable UUID id ) {
        return ResponseEntity.ok( tradeMediatorFacade.getBankUpdatableTransactions( id ) );
    }

    @PostMapping( "approve-transaction" )
    public ResponseEntity<TransactionDTO> approveTransaction( @Valid @RequestBody BankApprovedTransactionDTO approvalRequest ) {
        return ResponseEntity.ok( tradeMediatorFacade.approveTransactionByBank( approvalRequest ) );
    }

    @PostMapping( "reject-transaction" )
    public ResponseEntity<TransactionDTO> rejectTransaction( @Valid @RequestBody BankRejectedTransactionDTO rejectionRequest ) {
        return ResponseEntity.ok( tradeMediatorFacade.rejectTransactionByBank( rejectionRequest ) );
    }

}