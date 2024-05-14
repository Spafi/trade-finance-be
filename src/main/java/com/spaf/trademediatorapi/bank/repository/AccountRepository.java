package com.spaf.trademediatorapi.bank.repository;

import com.spaf.trademediatorapi.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    Set<Account> findAllByBankId( UUID bankId );
}