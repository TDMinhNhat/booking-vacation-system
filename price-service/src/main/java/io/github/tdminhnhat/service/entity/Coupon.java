package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity @Table(name = "coupons")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class Coupon extends AbstractEntityProperty {

    @Column(name = "coupon_code", length = 50, nullable = false, unique = true)
    @NonNull
    private String couponCode;

    @Column(name = "coupon_name", length = 200, nullable = false, unique = true)
    @NonNull
    private String couponName;

    @Column(name = "start_date", nullable = false)
    @NonNull
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    @NonNull
    private LocalDate endDate;

    public Coupon(String description, @NonNull String couponCode, @NonNull String couponName, @NonNull LocalDate startDate, @NonNull LocalDate endDate) {
        super(description);
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
