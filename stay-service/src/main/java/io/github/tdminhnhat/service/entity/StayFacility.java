package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    @ManyToOne @JoinColumn(name = "facility_id", nullable = false)
    @NonNull
    private Facility facility;

    public StayFacility(String description, @NonNull Stay stay, @NonNull Facility facility) {
        super(description);
        this.stay = stay;
        this.facility = facility;
    }
}
