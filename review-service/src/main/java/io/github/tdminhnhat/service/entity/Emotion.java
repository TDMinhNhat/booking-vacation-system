package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "emotions")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class Emotion extends AbstractEntityProperty {

    @Column(name = "emotion_name", length = 100, nullable = false, unique = true)
    @NonNull
    private String name;

    @Column(name = "image_url", length = 500, nullable = false)
    @NonNull
    private String imageUrl;

    public Emotion(String description, @NonNull String name, @NonNull String imageUrl) {
        super(description);
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
