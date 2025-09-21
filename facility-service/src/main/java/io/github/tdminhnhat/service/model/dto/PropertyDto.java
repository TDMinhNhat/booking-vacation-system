package io.github.tdminhnhat.service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record PropertyDto(@Size(message = "max length is 300 characters", max = 300) String description,
                          @Size(max = 200, message = "max length is 200 characters") @NotBlank(message = "can not be null or empty") String name) implements Serializable {
}