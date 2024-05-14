package com.spaf.trademediatorapi.importer.model;

import com.spaf.trademediatorapi.core.model.BaseEntity;
import com.spaf.trademediatorapi.importer.dto.ImporterDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Importer extends BaseEntity {

    @NotEmpty( message = "Importer name must not be empty" )
    @Column( nullable = false )
    private String name;

    public ImporterDTO toDto() {
        return ImporterDTO.builder()
                          .id( id )
                          .name( name )
                          .build();
    }

}