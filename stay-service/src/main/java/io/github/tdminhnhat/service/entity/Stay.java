package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;

@Entity @Table(name = "stays")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class Stay extends AbstractEntityProperty {

    @Column(name = "stay_code", length = 50, nullable = false, unique = true)
    @NonNull
    private String code;

    @Column(name = "stay_name", length = 200, nullable = false)
    @NonNull
    private String name;

    @Column(name = "address", length = 400, nullable = false)
    @NonNull
    private String address;

    @Column(name = "city_id", nullable = false)
    @NonNull
    private Long cityId;

    @ManyToOne @JoinColumn(name = "category_id", nullable = false)
    @NonNull
    private Category category;

}
