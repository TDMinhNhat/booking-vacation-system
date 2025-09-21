package io.github.tdminhnhat.service.model.qo;

import io.github.tdminhnhat.core.model.dto.PageRequestDto;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;

public record FacilityQo(@Positive(message = "must be a positive number") Long id, Boolean delete,
                         Instant beginCreatedAt, Instant endCreatedAt,
                         Instant beginUpdatedAt, Instant endUpdatedAt,
                         @Size(message = "max length is {max} characters", max = 50) String createdBy,
                         @Size(message = "max length is {max} characters", max = 50) String updatedBy,
                         @Size(message = "max length is {max} characters", max = 50) String code,
                         @Size(max = 200, message = "max length is {max} characters") String name,
                         PageRequestDto pageRequest) implements Serializable {
}