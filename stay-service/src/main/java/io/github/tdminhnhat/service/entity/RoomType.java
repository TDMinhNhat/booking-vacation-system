package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "room_types")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class RoomType extends AbstractEntityProperty {

    @ManyToOne @JoinColumn(name = "stay_id", nullable = false)
    @NonNull
    private Stay stay;

    @Column(name = "room_type_name", length = 300, nullable = false)
    @NonNull
    private String name;

    @Column(name = "size", nullable = false)
    @NonNull
    private Double size;

    public RoomType(String description, @NonNull Stay stay, @NonNull String name, @NonNull Double size) {
        super(description);
        this.stay = stay;
        this.name = name;
        this.size = size;
    }
}
