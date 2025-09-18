package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity @Table(name = "countries")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Country extends AbstractEntityProperty {

    @Column(name = "country_code", length = 50, nullable = false, unique = true)
    @NonNull
    private String countryCode;

    @Column(name = "country_name", length = 200, nullable = false, unique = true)
    @NonNull
    private String countryName;

    @Column(name = "image_url", length = 400)
    private String imageURL;

    public Country(String description, @NonNull String countryCode, @NonNull String countryName, String imageURL) {
        super(description);
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.imageURL = imageURL;
    }
}
