package com.spaf.trademediatorapi.util;

import com.spaf.trademediatorapi.transaction.model.Transaction;
import com.spaf.trademediatorapi.transaction.model.TransactionStatus;
import com.spaf.trademediatorapi.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ScheduledTasks {

    private final TransactionRepository transactionRepository;

    // Every day at 3:00 AM
    @Scheduled( cron = "0 0 3 * * ?", zone = "Europe/Bucharest" )
    @Transactional
    public void calculateAndSaveVat() {
        Set<Transaction> approvedTransactions = transactionRepository.findAllByStatus( TransactionStatus.APPROVED_BY_EXPORTER );
        for ( Transaction transaction : approvedTransactions ) {
            if ( transaction.getNetPrice() != null ) {
                BigDecimal vat = transaction.getNetPrice()
                                            .multiply( BigDecimal.valueOf( 0.20 ) );
                transaction.setVat( vat );
                transactionRepository.save( transaction );
            }
        }
    }
}