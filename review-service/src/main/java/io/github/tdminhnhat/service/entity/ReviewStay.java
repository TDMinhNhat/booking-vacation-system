package io.github.tdminhnhat.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "review_stays")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class ReviewStay extends Review {

    @Column(name = "stay_id", nullable = false)
    @NonNull
    private Long stay;

    @Column(name = "staff_score", nullable = false)
    @NonNull
    private Integer staffScore;

    @Column(name = "facilities_score", nullable = false)
    @NonNull
    private Integer facilitiesScore;

    @Column(name = "cleanliness_score", nullable = false)
    @NonNull
    private Integer cleanlinessScore;

    @Column(name = "comfort_score", nullable = false)
    @NonNull
    private Integer comfortScore;

    @Column(name = "value_of_money_score", nullable = false)
    @NonNull
    private Integer valueOfMoneyScore;

    @Column(name = "location_score", nullable = false)
    @NonNull
    private Integer locationScore;

    @Column(name = "wifi_score", nullable = false)
    @NonNull
    private Integer wifiScore;

    public ReviewStay(String description, @NonNull String title, @NonNull String reviewGood, @NonNull String reviewBad, @NonNull Integer rating, @NonNull Long userId, Long bookingId, @NonNull Long stay, @NonNull Integer staffScore, @NonNull Integer facilitiesScore, @NonNull Integer cleanlinessScore, @NonNull Integer comfortScore, @NonNull Integer valueOfMoneyScore, @NonNull Integer locationScore, @NonNull Integer wifiScore) {
        super(description, title, reviewGood, reviewBad, rating, userId, bookingId);
        this.stay = stay;
        this.staffScore = staffScore;
        this.facilitiesScore = facilitiesScore;
        this.cleanlinessScore = cleanlinessScore;
        this.comfortScore = comfortScore;
        this.valueOfMoneyScore = valueOfMoneyScore;
        this.locationScore = locationScore;
        this.wifiScore = wifiScore;
    }
}
