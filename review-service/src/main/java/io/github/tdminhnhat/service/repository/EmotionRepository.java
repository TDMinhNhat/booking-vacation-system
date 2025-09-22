package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionRepository extends JpaRepository<Emotion, Long> {
}
