package io.github.tdminhnhat.service.model.vo;

import java.io.Serializable;

/**
 * DTO for {@link io.github.tdminhnhat.service.entity.Service}
 */
public record ServiceVo(Long id, String description, Boolean delete, String code, String serviceType, String name,
                        String imageUrl) implements Serializable {
}