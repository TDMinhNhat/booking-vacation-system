package io.github.tdminhnhat.service.model.vo;

import java.io.Serializable;
import java.time.LocalDate;


public record UserVo(Long id, String description, String userId, String firstName, String lastName, Boolean sex,
                     LocalDate birthDate, String phoneNumber, String address, String avatar, String username,
                     String email, String role) implements Serializable {
}