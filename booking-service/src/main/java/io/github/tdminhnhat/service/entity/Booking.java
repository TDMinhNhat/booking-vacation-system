package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import io.github.tdminhnhat.service.enums.BookingStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public abstract class Booking extends AbstractEntityProperty {

    @Column(name = "booking_id", length = 50, nullable = false, unique = true)
    private String bookingId;

    @Column(name = "user_id", nullable = false)
    @NonNull
    private Long userId;

    @Column(name = "currency_id", nullable = false)
    @NonNull
    private Long currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 100, nullable = false)
    @NonNull
    private BookingStatus status;

    public Booking(String description, String bookingId, @NonNull Long userId, @NonNull Long currency, @NonNull BookingStatus status) {
        super(description);
        this.bookingId = bookingId;
        this.userId = userId;
        this.currency = currency;
        this.status = status;
    }
}
