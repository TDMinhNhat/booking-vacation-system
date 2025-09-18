package io.github.tdminhnhat.core.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class PageRequestDto {

    @NotBlank(message = "'page' can not be null or empty")
    @PositiveOrZero(message = "'page' should be a number greater than or equal 0")
    private long page;

    @NotBlank(message = "'size' can not be null or empty")
    @Positive(message = "'page' should be a number greater than 0")
    private long size;

    private List<SortRequestDto> sortRequest;

    public Pageable getPageable() {
        return Pageable.ofSize((int) size).withPage((int) page);
    }

    public List<Sort.Order> getSort() {
        return sortRequest.stream()
                .map(sortProperty -> new Sort.Order(Sort.Direction.valueOf(sortProperty.getTypeOrder()), sortProperty.getProperty()))
                .toList();
    }
}
