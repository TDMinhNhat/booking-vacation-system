package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "stay_services")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class StayService extends AbstractEntityProperty {

    @ManyToOne @JoinColumn(name = "stay_id", nullable = false)
    @NonNull
    private Stay stay;

    @Column(name = "service_id", nullable = false)
    @NonNull
    private Long service;

    public StayService(String description, @NonNull Stay stay, @NonNull Long service) {
        super(description);
        this.stay = stay;
        this.service = service;
    }
}
