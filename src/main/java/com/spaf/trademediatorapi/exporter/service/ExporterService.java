package com.spaf.trademediatorapi.exporter.service;

import com.spaf.trademediatorapi.exporter.repository.ExporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExporterService {

    private final ExporterRepository exporterRepository;


}