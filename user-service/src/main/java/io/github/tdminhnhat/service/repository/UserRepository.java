package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
