package com.spaf.trademediatorapi.exporter.model;

import com.spaf.trademediatorapi.core.model.BaseEntity;
import com.spaf.trademediatorapi.exporter.dto.ExporterDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@ToString
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Exporter extends BaseEntity {

    @NotEmpty( message = "Exporter name must not be empty" )
    private String name;

    public ExporterDTO toDto() {
        return ExporterDTO.builder()
                          .id( id )
                          .name( name )
                          .build();
    }

}