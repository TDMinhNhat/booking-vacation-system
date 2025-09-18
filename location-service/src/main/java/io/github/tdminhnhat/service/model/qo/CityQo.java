package io.github.tdminhnhat.service.model.qo;

import io.github.tdminhnhat.core.model.dto.PageRequestDto;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.ZonedDateTime;

public record CityQo(@Positive(message = "should be positive number") Long id, Boolean delete,
                     ZonedDateTime beginCreatedAt, ZonedDateTime endCreatedAt,
                     ZonedDateTime beginUpdatedAt, ZonedDateTime endUpdatedAt,
                     @Size(message = "max length is 200 characters", max = 200) String cityName,
                     @Size(message = "max length is 50 characters", max = 50) String countryCode,
                     PageRequestDto pageRequest) implements Serializable {
}