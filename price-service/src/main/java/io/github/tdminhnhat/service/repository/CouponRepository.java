package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
