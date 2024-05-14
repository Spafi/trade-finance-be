package com.spaf.trademediatorapi.exporter.dto;

import com.spaf.trademediatorapi.exporter.model.Exporter;
import com.spaf.trademediatorapi.importer.model.Importer;
import lombok.Builder;

import java.util.UUID;

@Builder
public record ExporterDTO(
        UUID id,
        String name
) {

    public Exporter toEntity() {
        return Exporter.builder()
                       .id( id )
                       .name( name )
                       .build();
    }
}