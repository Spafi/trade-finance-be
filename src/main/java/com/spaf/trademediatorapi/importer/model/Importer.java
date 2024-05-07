package com.spaf.trademediatorapi.importer.model;

import com.spaf.trademediatorapi.core.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
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

    @Email
    @Column
    private String email;

    @Column
    private String phone;

}