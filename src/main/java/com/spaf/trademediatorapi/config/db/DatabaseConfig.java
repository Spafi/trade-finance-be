package com.spaf.trademediatorapi.config.db;

import com.spaf.trademediatorapi.bank.model.Account;
import com.spaf.trademediatorapi.bank.model.Bank;
import com.spaf.trademediatorapi.bank.repository.BankRepository;
import com.spaf.trademediatorapi.exporter.model.Exporter;
import com.spaf.trademediatorapi.exporter.repository.ExporterRepository;
import com.spaf.trademediatorapi.importer.model.Importer;
import com.spaf.trademediatorapi.importer.repository.ImporterRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.MessageFormat;
import java.util.LinkedHashSet;
import java.util.Set;

@RequiredArgsConstructor
@Configuration
public class DatabaseConfig {

    private static final Logger log = LoggerFactory.getLogger( DatabaseConfig.class );

    private final ImporterRepository importerRepository;
    private final BankRepository bankRepository;
    private final ExporterRepository exporterRepository;


    @Bean
    @ConditionalOnProperty( name = "app.insertMockDataOnStartup", havingValue = "true" )
    public CommandLineRunner dataLoader() {
        return args -> {
            log.info( "Inserting mock data" );

            boolean hasImporters = importerRepository.count() > 0;
            boolean hasBanks = bankRepository.count() > 0;
            boolean hasExporters = exporterRepository.count() > 0;

            if ( !hasImporters ) {
                insertImporters( 10 );
            }
            
            if ( !hasBanks ) {
                insertBanks( 10 );
            }

            if ( !hasExporters ) {
                insertExporters( 10 );
            }

            log.info( "Successfully inserted mock data" );
        };
    }

    private void insertImporters( Integer amount ) {
        log.info( MessageFormat.format( "Inserting {0} {1} in the database", amount, "importers" ) );

        for ( int i = 0; i < amount; i++ ) {
            Importer importer = Importer.builder()
                                        .name( "importer" + ( i + 1 ) )
                                        .build();
            importerRepository.save( importer );
        }
        log.info( MessageFormat.format( "Successfully inserted {0} {1} in the database", amount, "importers" ) );

    }

    private void insertBanks( Integer amount ) {
        log.info( MessageFormat.format( "Inserting {0} {1} in the database", amount, "banks" ) );


        for ( int i = 0; i < amount; i++ ) {

            Bank bank = Bank.builder()
                            .name( "bank" + ( i + 1 ) )
                            .build();

            Set<Account> accounts = generateBankAccounts( bank, 5 );
            bank.setAccounts( accounts );
            bankRepository.save( bank );
        }

        log.info( MessageFormat.format( "Successfully inserted {0} {1} in the database", amount, "banks" ) );
    }

    private Set<Account> generateBankAccounts( Bank bank, Integer amount ) {
        int length = 10;
        boolean useLetters = false;
        boolean useNumbers = true;

        Set<Account> accounts = new LinkedHashSet<>();
        for ( int i = 0; i < amount; i++ ) {
            Account account = Account.builder()
                                     .accountNumber( RandomStringUtils.random( length, useLetters, useNumbers ) )
                                     .bank( bank )
                                     .build();
            accounts.add( account );
        }

        return accounts;
    }

    private void insertExporters( Integer amount ) {
        log.info( MessageFormat.format( "Inserting {0} {1} in the database", amount, "exporters" ) );

        for ( int i = 0; i < amount; i++ ) {
            Exporter exporter = Exporter.builder()
                                        .name( "exporter" + ( i + 1 ) )
                                        .build();
            exporterRepository.save( exporter );
        }
        log.info( MessageFormat.format( "Successfully inserted {0} {1} in the database", amount, "exporters" ) );

    }
}