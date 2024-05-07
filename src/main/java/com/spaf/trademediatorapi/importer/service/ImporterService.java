package com.spaf.trademediatorapi.importer.service;

import com.spaf.trademediatorapi.importer.repository.ImporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImporterService {

    private final ImporterRepository importerRepository;


}