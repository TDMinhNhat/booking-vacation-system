package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "cities")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class City extends AbstractEntityProperty {

    @Column(name = "city_name", length = 200, nullable = false)
    @NonNull
    private String cityName;

    @Column(name = "image_url", length = 400)
    private String imageURL;

    @ManyToOne @JoinColumn(name = "country_id", nullable = false)
    @NonNull
    private Country country;

    public City(String description, @NonNull String cityName, String imageURL, @NonNull Country country) {
        super(description);
        this.cityName = cityName;
        this.imageURL = imageURL;
        this.country = country;
    }
}
