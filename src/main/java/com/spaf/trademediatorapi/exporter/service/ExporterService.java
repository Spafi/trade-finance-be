package com.spaf.trademediatorapi.exporter.service;

import com.spaf.trademediatorapi.exporter.dto.ExporterDTO;
import com.spaf.trademediatorapi.exporter.exception.ExporterNotFoundException;
import com.spaf.trademediatorapi.exporter.model.Exporter;
import com.spaf.trademediatorapi.exporter.repository.ExporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExporterService {

    private final ExporterRepository exporterRepository;

    public List<ExporterDTO> findAll() {
        return exporterRepository.findAll()
                                 .stream()
                                 .map( Exporter::toDto )
                                 .toList();
    }

    public Exporter findById( UUID id ) {
        return exporterRepository.findById( id )
                                 .orElseThrow( () -> new ExporterNotFoundException( id ) );
    }


}