package io.github.tdminhnhat.service.model.qo;

import io.github.tdminhnhat.core.model.dto.PageRequestDto;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;

public record CityQo(@Positive(message = "should be positive number") Long id, Boolean delete,
                     Instant beginCreatedAt, Instant endCreatedAt,
                     Instant beginUpdatedAt, Instant endUpdatedAt,
                     @Size(message = "max length is 200 characters", max = 200) String cityName,
                     @Size(message = "max length is 50 characters", max = 50) String countryCode,
                     @ModelAttribute PageRequestDto pageRequest) implements Serializable {
}