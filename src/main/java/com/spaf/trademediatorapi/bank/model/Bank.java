package com.spaf.trademediatorapi.bank.model;

import com.spaf.trademediatorapi.core.model.BaseEntity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Bank extends BaseEntity {

    @NotEmpty( message = "Bank name must not be empty" )
    private String name;

    @ToString.Exclude
    @ElementCollection( targetClass = String.class )
    private Set<String> accounts = new HashSet<>();

}