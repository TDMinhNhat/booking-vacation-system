package io.github.tdminhnhat.service.model.qo;

import io.github.tdminhnhat.core.model.dto.PageRequestDto;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;

public record CountryQo(@Positive(message = "should be a positive number") Long id, Boolean delete,
                        Instant beginCreatedAt, Instant endCreatedAt,
                        Instant beginUpdatedAt, Instant endUpdatedAt,
                        @Size(message = "max length is 50 characters", max = 50) String countryCode,
                        @Size(message = "max length is 200 characters", max = 200) String countryName,
                        @ModelAttribute PageRequestDto pageRequest) implements Serializable {
}