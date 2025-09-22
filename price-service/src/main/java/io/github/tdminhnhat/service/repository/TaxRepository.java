package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Long> {
}
