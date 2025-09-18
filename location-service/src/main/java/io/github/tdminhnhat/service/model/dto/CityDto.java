package io.github.tdminhnhat.service.model.dto;

import io.github.tdminhnhat.core.model.dto.PageRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record CityDto(@Size(message = "max length is 300 characters", max = 300) String description,
                      @Size(message = "max length is 200 characters", max = 200)
                      @NotBlank(message = "can not be null or empty") String cityName,
                      @NotNull(message = "can not be null or empty") String countryCode) implements Serializable {
}