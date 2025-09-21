package io.github.tdminhnhat.service.model.qo;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;

public record PropertyQo(@Positive(message = "should be a positive number") Long id, Boolean delete,
                         Instant beginCreatedAt, Instant endCreatedAt,
                         Instant beginUpdatedAt, Instant endUpdatedAt,
                         @Size(max = 50, message = "max length is {max} characters")
                          String createdBy,
                         @Size(max = 50, message = "max length is {max} characters")
                          String updatedBy,
                         @Size(max = 200, message = "max length is {max} characters") String name
) implements Serializable {
}