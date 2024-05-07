package com.spaf.trademediatorapi.bank.service;

import com.spaf.trademediatorapi.bank.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;


}