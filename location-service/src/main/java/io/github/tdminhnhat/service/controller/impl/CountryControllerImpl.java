package io.github.tdminhnhat.service.controller.impl;

import io.github.tdminhnhat.service.controller.IManagementController;
import io.github.tdminhnhat.service.model.dto.CountryDto;
import io.github.tdminhnhat.service.model.qo.CountryQo;
import io.github.tdminhnhat.service.service.ICountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/country")
@RequiredArgsConstructor
public class CountryControllerImpl implements IManagementController<CountryDto, String, CountryQo> {

    private final ICountryService countryService;

    @PostMapping
    @Override
    public ResponseEntity<?> add(@Valid @RequestBody CountryDto entity) {
        return ResponseEntity.ok(countryService.add(entity));
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Collection<?>> addList(@Valid @RequestBody Collection<CountryDto> list) {
        return ResponseEntity.ok(countryService.addList(list));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable("id") String id, @Valid @RequestBody CountryDto entity) {
        return ResponseEntity.ok(countryService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok(countryService.delete(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(countryService.getById(id));
    }

    @GetMapping
    @Override
    public ResponseEntity<PageImpl<?>> getAll(@Valid @RequestAttribute CountryQo filter) {
        return ResponseEntity.ok(countryService.getAll(filter));
    }
}
