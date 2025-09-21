package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "rules")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class Rule extends AbstractEntityProperty {

    @Column(name = "rule_code", length = 50, nullable = false, unique = true)
    @NonNull
    private String code;

    @Column(name = "rule_name", length = 300, nullable = false, unique = true)
    @NonNull
    private String name;

    @Column(name = "image_url", length = 400)
    private String imageUrl;

    public Rule(String description, @NonNull String code, @NonNull String name, String imageUrl) {
        super(description);
        this.code = code;
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
