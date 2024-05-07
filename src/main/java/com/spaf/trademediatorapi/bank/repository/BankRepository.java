package com.spaf.trademediatorapi.bank.repository;

import com.spaf.trademediatorapi.bank.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {
}