package io.github.tdminhnhat.service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record FacilityDto(@Size(max = 300) String description,
                          @Size(message = "max length is 50 characters", max = 50) @NotBlank(message = "can not be null or empty") String code,
                          @Size(message = "max length is 200 characters", max = 200) @NotBlank(message = "can not be null or empty") String name) implements Serializable {
}