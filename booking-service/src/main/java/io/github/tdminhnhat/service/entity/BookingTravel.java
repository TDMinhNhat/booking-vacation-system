package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.service.enums.BookingStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "booking_travel")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class BookingTravel extends Booking {

    @Column(name = "price_room_type_id", nullable = false)
    @NonNull
    private Long priceRoomType;

    @Column(name = "quantity", nullable = false)
    @NonNull
    private Integer quantity;

    public BookingTravel(String description, String bookingId, @NonNull Long userId, @NonNull Long currency, @NonNull BookingStatus status, @NonNull Long priceRoomType, @NonNull Integer quantity) {
        super(description, bookingId, userId, currency, status);
        this.priceRoomType = priceRoomType;
        this.quantity = quantity;
    }
}
