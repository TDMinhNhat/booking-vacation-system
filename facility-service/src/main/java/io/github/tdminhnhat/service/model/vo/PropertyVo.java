package io.github.tdminhnhat.service.model.vo;

import java.io.Serializable;

public record PropertyVo(
        Long id, String description, Boolean delete, String name,
                         String imageUrl) implements Serializable {
}