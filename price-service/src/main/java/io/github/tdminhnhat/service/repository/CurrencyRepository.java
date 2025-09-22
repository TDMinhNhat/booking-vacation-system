package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
