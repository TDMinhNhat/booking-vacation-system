package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
