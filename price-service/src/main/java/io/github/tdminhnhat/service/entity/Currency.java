package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "currencies")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class Currency extends AbstractEntityProperty {

    @Column(name = "country_id", nullable = false)
    @NonNull
    private Long countryId;

    @Column(name = "currency_code", length = 50, nullable = false, unique = true)
    @NonNull
    private String code;

    @Column(name = "currency_name", length = 200, nullable = false, unique = true)
    @NonNull
    private String name;

    @Column(name = "currency_symbol", length = 50, nullable = false, unique = true)
    @NonNull
    private String symbol;

    public Currency(String description, @NonNull Long countryId, @NonNull String code, @NonNull String name, @NonNull String symbol) {
        super(description);
        this.countryId = countryId;
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }
}
