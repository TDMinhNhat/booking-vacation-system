package io.github.tdminhnhat.service.model.qo;

import io.github.tdminhnhat.core.model.dto.PageRequestDto;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

public record UserQo(
        @Positive(message = "must be a positive number")
        Long id,
        Boolean delete,
        Instant beginCreatedAt,
        Instant endCreatedAt,
        Instant beginUpdatedAt,
        Instant endUpdatedAt,
        @Size(max = 50, message = "max length is {max} characters")
        String createdBy,
        @Size(max = 50, message = "max length is {max} characters")
        String updatedBy,
        @Size(max = 50, message = "max length is {max} characters")
        String userId,
        @Size(max = 100, message = "max length is {max} characters")
        String firstName,
        @Size(max = 100, message = "max length is {max} characters")
        String lastName,
        Boolean sex,
        LocalDate birthDate,
        @Size(max = 30, message = "max length is {max} characters")
        String phoneNumber,
        @Size(max = 100, message = "max length is {max} characters")
        String username,
        @Size(max = 200, message = "max length is {max} characters")
        String email,
        @Size(max = 100, message = "max length is {max} characters")
        String role,
        Boolean blocking,
        PageRequestDto pageRequest
) implements Serializable {
}