package io.github.tdminhnhat.core.model.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
abstract class SortRequestDto {
    private String property;

    @Pattern(regexp = "(ASC|DESC)", message = "'typeOrder' only allow the value ASC (Ascending) or DESC (Descending)")
    private String typeOrder;
}
