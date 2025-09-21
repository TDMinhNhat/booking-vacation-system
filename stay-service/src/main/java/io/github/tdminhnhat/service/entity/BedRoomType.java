package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "bed_room_types")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class BedRoomType extends AbstractEntityProperty {

    @Transient
    private final String SINGLE = "SINGLE";

    @Transient
    private final String DOUBLE = "DOUBLE";

    @Transient
    private final String TRIPLE = "TRIPLE";

    @Transient
    private final String QUAD = "QUAD";

    @ManyToOne @JoinColumn(name = "room_type_id", nullable = false)
    @NonNull
    private RoomType roomType;

    @Column(name = "type_bedroom", length = 50, nullable = false)
    @NonNull
    private String typeBedroom;

    @Column(name = "quantity", nullable = false)
    @NonNull
    private Integer quantity;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    public BedRoomType(String description, @NonNull RoomType roomType, @NonNull String typeBedroom, @NonNull Integer quantity, String imageUrl) {
        super(description);
        this.roomType = roomType;
        this.typeBedroom = typeBedroom;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }
}
