package com.spaf.trademediatorapi.importer.service;

import com.spaf.trademediatorapi.importer.dto.ImporterDTO;
import com.spaf.trademediatorapi.importer.exception.ImporterNotFoundException;
import com.spaf.trademediatorapi.importer.model.Importer;
import com.spaf.trademediatorapi.importer.repository.ImporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImporterService {

    private final ImporterRepository importerRepository;

    public List<ImporterDTO> findAll() {
        return importerRepository.findAll()
                                 .stream()
                                 .map( Importer::toDto )
                                 .toList();
    }

    public Importer findById( UUID id ) {
        return importerRepository.findById( id )
                                 .orElseThrow( () -> new ImporterNotFoundException( id ) );
    }

}