package io.github.tdminhnhat.service.model.qo;

import io.github.tdminhnhat.core.model.dto.PageRequestDto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

public record UserQo(Long id,
                     Boolean delete,
                     Instant beginCreatedAt,
                     Instant endCreatedAt,
                     Instant beginUpdatedAt,
                     Instant endUpdatedAt,
                     String createdBy,
                     String updatedBy,
                     String userId,
                     String firstName,
                     String lastName,
                     Boolean sex,
                     LocalDate birthDate,
                     String phoneNumber,
                     String username,
                     String email,
                     String role,
                     Boolean blocking,
                     PageRequestDto pageRequest
) implements Serializable {
}