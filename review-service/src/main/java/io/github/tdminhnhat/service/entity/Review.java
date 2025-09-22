package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public abstract class Review extends AbstractEntityProperty {

    @Column(name = "title", length = 200, nullable = false)
    @NonNull
    private String title;

    @Lob
    @Column(name = "review_good", nullable = false, columnDefinition = "TEXT DEFAULT ''")
    @NonNull
    private String reviewGood;

    @Lob
    @Column(name = "review_bad", nullable = false, columnDefinition = "TEXT DEFAULT ''")
    @NonNull
    private String reviewBad;

    @Column(name = "rating", nullable = false)
    @NonNull
    private Integer rating;

    @Column(name = "user_id", nullable = false)
    @NonNull
    private Long userId;

    @Column(name = "booking_id", nullable = false)
    private Long bookingId;

    public Review(String description, @NonNull String title, @NonNull String reviewGood, @NonNull String reviewBad, @NonNull Integer rating, @NonNull Long userId, Long bookingId) {
        super(description);
        this.title = title;
        this.reviewGood = reviewGood;
        this.reviewBad = reviewBad;
        this.rating = rating;
        this.userId = userId;
        this.bookingId = bookingId;
    }
}
