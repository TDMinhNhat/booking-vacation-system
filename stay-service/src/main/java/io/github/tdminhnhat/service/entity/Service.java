package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "services")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class Service extends AbstractEntityProperty {

    @Column(name = "service_code", length = 50, nullable = false, unique = true)
    @NonNull
    private String code;

    @Column(name = "service_name", length = 100, nullable = false, unique = true)
    @NonNull
    private String name;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    public Service(String description, @NonNull String code, @NonNull String name, String imageUrl) {
        super(description);
        this.code = code;
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
