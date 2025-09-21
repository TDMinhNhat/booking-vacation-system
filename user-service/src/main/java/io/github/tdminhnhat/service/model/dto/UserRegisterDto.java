package io.github.tdminhnhat.service.model.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

public record UserRegisterDto(
        @Size(max = 300, message = "can not be null or empty")
        String description,
        @NotBlank(message = "can not be null or empty")
        @Size(max = 100, message = "max length is {max} characters")
        String firstName,
        @NotBlank(message = "can not be null or empty")
        @Size(max = 100, message = "max length is {max} characters")
        String lastName,
        @NotNull(message = "can not be null or empty")
        Boolean sex,
        @NotNull(message = "can not be null or empty")
        @PastOrPresent(message = "must be a date in the past or present")
        LocalDate birthDate,
        @NotBlank(message = "can not be null or empty")
        @Size(max = 30, message = "max length is {max} characters")
        String phoneNumber,
        @Size(max = 400, message = "max length is {max} characters")
        String address,
        @NotBlank(message = "can not be null or empty")
        @Size(max = 100, message = "max length is {max} characters")
        String username,
        @NotBlank(message = "can not be null or empty")
        @Size(max = 200, message = "max length is {max} characters")
        String email,
        @NotBlank(message = "can not be null or empty")
        @Size(min = 8, max = 200, message = "length must be between {min} and {max} characters")
        String password
) implements Serializable {
}