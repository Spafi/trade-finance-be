package com.spaf.trademediatorapi.importer.dto;

import com.spaf.trademediatorapi.importer.model.Importer;
import lombok.Builder;

import java.util.UUID;

@Builder
public record ImporterDTO(
        UUID id,
        String name,
        String email,
        String phone
) {

    public Importer toEntity() {
        return Importer.builder()
                       .id( id )
                       .name( name )
                       .build();
    }
}