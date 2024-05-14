package com.spaf.trademediatorapi.bank.service;

import com.spaf.trademediatorapi.bank.dto.AccountDTO;
import com.spaf.trademediatorapi.bank.dto.BankDTO;
import com.spaf.trademediatorapi.bank.exception.AccountNotFoundException;
import com.spaf.trademediatorapi.bank.exception.BankNotFoundException;
import com.spaf.trademediatorapi.bank.model.Account;
import com.spaf.trademediatorapi.bank.model.Bank;
import com.spaf.trademediatorapi.bank.repository.AccountRepository;
import com.spaf.trademediatorapi.bank.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;
    private final AccountRepository accountRepository;

    public List<BankDTO> findAll() {
        return bankRepository.findAll()
                             .stream()
                             .map( Bank::toDto )
                             .toList();
    }

    public Bank findById( UUID id ) {
        return bankRepository.findById( id )
                             .orElseThrow( () -> new BankNotFoundException( id ) );
    }

    public List<AccountDTO> findBankAccounts( UUID bankId ) {
        return accountRepository.findAllByBankId( bankId )
                                .stream()
                                .map( Account::toDto )
                                .toList();
    }

    public Account findBankAccount( UUID accountId ) {
        return accountRepository.findById( accountId )
                                .orElseThrow( () -> new AccountNotFoundException( accountId ) );
    }
}