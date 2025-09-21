package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.AbstractEntityProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "stay_rules")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class StayRule extends AbstractEntityProperty {

    @ManyToOne @JoinColumn(name = "stay_id", nullable = false)
    @NonNull
    private Stay stay;

    @JoinColumn(name = "rule_id", nullable = false)
    @NonNull
    private Long rule;

    public StayRule(String description, @NonNull Stay stay, @NonNull Long rule) {
        super(description);
        this.stay = stay;
        this.rule = rule;
    }
}
