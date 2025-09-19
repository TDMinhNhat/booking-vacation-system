package io.github.tdminhnhat.core.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class PageRequestDto {

    @NotBlank(message = "'page' can not be null or empty")
    @PositiveOrZero(message = "'page' should be a number greater than or equal 0")
    private long page;

    @NotBlank(message = "'size' can not be null or empty")
    @Positive(message = "'page' should be a number greater than 0")
    private long size;

    private List<SortRequestDto> sortRequest;

    @JsonIgnore
    public Pageable getPageable() {
        return Pageable.ofSize((int) size).withPage((int) page);
    }

    @JsonIgnore
    public List<Sort.Order> getSort() {
        return sortRequest.stream()
                .map(sortProperty -> new Sort.Order(Sort.Direction.valueOf(sortProperty.getTypeOrder()), sortProperty.getProperty()))
                .toList();
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public List<SortRequestDto> getSortRequest() {
        return sortRequest;
    }

    public void setSortRequest(List<SortRequestDto> sortRequest) {
        this.sortRequest = sortRequest;
    }
}
