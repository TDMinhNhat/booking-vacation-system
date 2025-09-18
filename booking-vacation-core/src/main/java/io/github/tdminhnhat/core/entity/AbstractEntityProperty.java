package io.github.tdminhnhat.core.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntityProperty {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "delete", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean delete;

    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    @Column(name = "created_by", length = 50, nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'SYSTEM'")
    private String createdBy;

    @Column(name = "updated_by", length = 30)
    private String updatedBy;

    public AbstractEntityProperty(String description) {
        this.description = description;
    }
}
