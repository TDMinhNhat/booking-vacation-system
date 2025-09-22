package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "review_emotions")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class ReviewStayEmotion extends AbstractEntityProperty {

    @ManyToOne @JoinColumn(name = "review_stay_id", nullable = false)
    @NonNull
    private ReviewStay reviewStay;

    @ManyToOne @JoinColumn(name = "emotion_id", nullable = false)
    @NonNull
    private Emotion emotion;

    @Column(name = "user_id", nullable = false)
    @NonNull
    private Long userId;

    public ReviewStayEmotion(String description, @NonNull ReviewStay reviewStay, @NonNull Emotion emotion, @NonNull Long userId) {
        super(description);
        this.reviewStay = reviewStay;
        this.emotion = emotion;
        this.userId = userId;
    }
}
