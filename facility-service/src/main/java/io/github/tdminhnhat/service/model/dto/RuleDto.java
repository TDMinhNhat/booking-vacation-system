package io.github.tdminhnhat.service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record RuleDto(@Size(message = "max length is 300 characters", max = 300) String description,
                      @Size(message = "max length is 50 characters", max = 50) @NotBlank(message = "can not be null or empty") String code,
                      @Size(max = 300) @NotBlank(message = "can not be null or empty") String name) implements Serializable {
}