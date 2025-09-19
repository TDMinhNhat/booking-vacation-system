package io.github.tdminhnhat.service.controller.impl;

import io.github.tdminhnhat.service.controller.IImageManagementController;
import io.github.tdminhnhat.service.controller.IManagementController;
import io.github.tdminhnhat.service.model.dto.CountryDto;
import io.github.tdminhnhat.service.model.qo.CountryQo;
import io.github.tdminhnhat.service.service.ICountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
@RequiredArgsConstructor
public class CountryControllerImpl implements IManagementController<CountryDto, String, CountryQo>, IImageManagementController<String> {

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

    @PostMapping("/get-list")
    @Override
    public ResponseEntity<PageImpl<?>> getAll(@Valid @RequestBody CountryQo filter) {
        return ResponseEntity.ok(countryService.getAll(filter));
    }

    @PostMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<?> addImage(@RequestParam("id") String id, @RequestPart("image") MultipartFile image) throws Exception {
        return ResponseEntity.ok(countryService.addImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> addListImages(String id, MultipartFile[] images) {
        return null;
    }

    @PutMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<?> updateImage(@RequestParam("id") String id, @RequestPart("image") MultipartFile image) throws Exception {
        return ResponseEntity.ok(countryService.updateImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> updateImages(String id, MultipartFile[] image) {
        return null;
    }

    @DeleteMapping("/{id}/image")
    @Override
    public ResponseEntity<?> deleteImage(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(countryService.deleteImage(id));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> deleteImages(String id) {
        return null;
    }
}
