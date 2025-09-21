package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "properties")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class Property extends AbstractEntityProperty {

    @Column(name = "property_name", length = 150, nullable = false, unique = true)
    @NonNull
    private String name;

    @Column(name = "image_url", length = 500)
    private String imageUrl;
}
