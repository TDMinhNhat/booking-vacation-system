package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity @Table(name = "discounts")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class Discount extends AbstractEntityProperty {

    @Column(name = "percent", nullable = false)
    @NonNull
    private Double percent;

    @Column(name = "start_date", nullable = false)
    @NonNull
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    @NonNull
    private LocalDate endDate;

    public Discount(String description, @NonNull Double percent, @NonNull LocalDate startDate, @NonNull LocalDate endDate) {
        super(description);
        this.percent = percent;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
