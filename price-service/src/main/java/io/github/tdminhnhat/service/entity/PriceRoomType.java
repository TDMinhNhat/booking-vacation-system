package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Entity @Table(name = "price_room_type")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class PriceRoomType extends AbstractEntityProperty {

    @Column(name = "room_type_id", nullable = false)
    @NonNull
    private Long roomType;

    @ManyToOne @JoinColumn(name = "tax_id", nullable = false)
    @NonNull
    private Tax tax;

    @Column(name = "value", nullable = false)
    @NonNull
    private BigDecimal value;

    @ManyToOne @JoinColumn(name = "discount_id", nullable = false)
    @NonNull
    private Discount discount;

    @Column(name = "price_breakfast", nullable = false)
    @NonNull
    private BigDecimal priceBreakfast;

    @Column(name = "allow_refundable", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    @NonNull
    private Boolean allowRefundable;

    @Column(name = "need_credit_card", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    @NonNull
    private Boolean needCreditCard;
}
