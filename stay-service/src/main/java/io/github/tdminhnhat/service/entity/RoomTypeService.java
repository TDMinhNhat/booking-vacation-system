package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "room_type_services")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class RoomTypeService extends AbstractEntityProperty {

    @ManyToOne @JoinColumn(name = "room_type_id", nullable = false)
    @NonNull
    private RoomType roomType;

    @Column(name = "service_id", nullable = false)
    @NonNull
    private Long serviceId;

    public RoomTypeService(String description, @NonNull RoomType roomType, @NonNull Long serviceId) {
        super(description);
        this.roomType = roomType;
        this.serviceId = serviceId;
    }
}
