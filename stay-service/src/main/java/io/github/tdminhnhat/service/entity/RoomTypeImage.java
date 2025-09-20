package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "room_type_images")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class RoomTypeImage extends AbstractEntityProperty {

    @ManyToOne @JoinColumn(name = "room_type_id", nullable = false)
    @NonNull
    private RoomType roomType;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    public RoomTypeImage(String description, @NonNull RoomType roomType, String imageUrl) {
        super(description);
        this.roomType = roomType;
        this.imageUrl = imageUrl;
    }
}
