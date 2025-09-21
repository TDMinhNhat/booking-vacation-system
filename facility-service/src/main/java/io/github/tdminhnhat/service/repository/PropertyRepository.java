package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
