package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "categories")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class StayCategory extends AbstractEntityProperty {

    @Column(name = "category_code", length = 50, nullable = false, unique = true)
    @NonNull
    private String categoryCode;

    @Column(name = "category_name", length = 200, nullable = false, unique = true)
    @NonNull
    private String categoryName;

    public StayCategory(String description, @NonNull String categoryCode, @NonNull String categoryName) {
        super(description);
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }
}
