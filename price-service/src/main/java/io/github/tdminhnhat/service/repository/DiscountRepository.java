package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
