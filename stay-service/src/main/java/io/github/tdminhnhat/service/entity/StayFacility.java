package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "stay_facilities")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class StayFacility extends AbstractEntityProperty {

    @ManyToOne @JoinColumn(name = "stay_id", nullable = false)
    @NonNull
    private Stay stay;

    @Column(name = "facility_id", nullable = false)
    @NonNull
    private Long facility;

    public StayFacility(String description, @NonNull Stay stay, @NonNull Long facility) {
        super(description);
        this.stay = stay;
        this.facility = facility;
    }
}
