package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "facilities")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class Facility extends AbstractEntityProperty {

    @Column(name = "facility_code", length = 50, nullable = false, unique = true)
    @NonNull
    private String code;

    @Column(name = "facility_name", length = 200, nullable = false, unique = true)
    @NonNull
    private String name;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    public Facility(String description, @NonNull String code, @NonNull String name) {
        super(description);
        this.code = code;
        this.name = name;
    }
}
