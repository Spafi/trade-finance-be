package com.spaf.trademediatorapi.core.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    protected UUID id;

    @Builder.Default
    protected LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public final boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null ) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ( ( HibernateProxy ) o ).getHibernateLazyInitializer()
                                                                                         .getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ( ( HibernateProxy ) this ).getHibernateLazyInitializer()
                                                                                                  .getPersistentClass() : this.getClass();
        if ( thisEffectiveClass != oEffectiveClass ) return false;
        BaseEntity that = ( BaseEntity ) o;
        return getId() != null && Objects.equals( getId(), that.getId() );
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ( ( HibernateProxy ) this ).getHibernateLazyInitializer()
                                                                           .getPersistentClass()
                                                                           .hashCode() : getClass().hashCode();
    }
}