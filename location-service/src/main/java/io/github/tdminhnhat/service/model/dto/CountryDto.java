package io.github.tdminhnhat.service.model.dto;

import io.github.tdminhnhat.core.model.dto.PageRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record CountryDto(
        @Size(message = "max length is 300 characters", max = 300)
        String description,

        @Size(message = "max length is 30 characters", max = 50)
        @NotBlank(message = "can not be null or empty")
        String countryCode,

        @Size(max = 200)
        @NotBlank(message = "can not be null or empty")
        String countryName
) implements Serializable {

}