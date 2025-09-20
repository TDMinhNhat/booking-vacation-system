package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    @ManyToOne @JoinColumn(name = "service_id", nullable = false)
    @NonNull
    private Service service;

    public StayService(String description, @NonNull Stay stay, @NonNull Service service) {
        super(description);
        this.stay = stay;
        this.service = service;
    }
}
