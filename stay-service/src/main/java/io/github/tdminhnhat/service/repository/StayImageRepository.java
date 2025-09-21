package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.StayImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StayImageRepository extends JpaRepository<StayImage, Long> {
}
