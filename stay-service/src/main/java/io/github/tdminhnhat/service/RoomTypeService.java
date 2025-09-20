package io.github.tdminhnhat.service;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import io.github.tdminhnhat.service.entity.RoomType;
import io.github.tdminhnhat.service.entity.Service;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    @ManyToOne @JoinColumn(name = "service_id", nullable = false)
    @NonNull
    private Service service;

    public RoomTypeService(String description, @NonNull RoomType roomType, @NonNull Service service) {
        super(description);
        this.roomType = roomType;
        this.service = service;
    }
}
