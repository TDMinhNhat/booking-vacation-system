package io.github.tdminhnhat.service.model.vo;

import java.io.Serializable;

/**
 * DTO for {@link io.github.tdminhnhat.service.entity.Rule}
 */
public record RuleVo(Long id, String description, Boolean delete, String code, String name,
                     String imageUrl) implements Serializable {
}