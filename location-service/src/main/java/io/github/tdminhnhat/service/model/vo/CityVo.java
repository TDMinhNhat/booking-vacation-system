package io.github.tdminhnhat.service.model.vo;

import io.github.tdminhnhat.service.entity.Country;

import java.io.Serializable;
import java.time.ZonedDateTime;

public record CityVo(Long id, String description, Boolean delete, ZonedDateTime createdAt, ZonedDateTime updatedAt,
                     String createdBy, String updatedBy, String cityName, String imageURL,
                     Country country) implements Serializable {
}