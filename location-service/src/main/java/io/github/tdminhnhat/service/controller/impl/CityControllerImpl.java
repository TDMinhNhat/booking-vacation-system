package io.github.tdminhnhat.service.controller.impl;

import io.github.tdminhnhat.service.controller.IImageManagementController;
import io.github.tdminhnhat.service.controller.IManagementController;
import io.github.tdminhnhat.service.model.dto.CityDto;
import io.github.tdminhnhat.service.model.qo.CityQo;
import io.github.tdminhnhat.service.service.ICityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/city")
@RequiredArgsConstructor
public class CityControllerImpl implements IManagementController<CityDto, Long, CityQo>, IImageManagementController<Long> {

    private final ICityService cityService;

    @PostMapping
    @Override
    public ResponseEntity<?> add(@Valid @RequestBody CityDto entity) {
        return ResponseEntity.ok(cityService.add(entity));
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Collection<?>> addList(@Valid @RequestBody Collection<CityDto> list) {
        return ResponseEntity.ok(cityService.addList(list));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody CityDto entity) {
        return ResponseEntity.ok(cityService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cityService.delete(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cityService.getById(id));
    }

    @GetMapping
    @Override
    public ResponseEntity<PageImpl<?>> getAll(@Valid @RequestAttribute CityQo filter) {
        return ResponseEntity.ok(cityService.getAll(filter));
    }

    @PostMapping("/{id}/image")
    @Override
    public ResponseEntity<?> addImage(@PathVariable("id") Long id, @RequestPart MultipartFile image) throws Exception {
        return ResponseEntity.ok(cityService.addImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> addListImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @PutMapping("/{id}/image")
    @Override
    public ResponseEntity<?> updateImage(@PathVariable("id") Long id, @RequestPart MultipartFile image) throws Exception {
        return ResponseEntity.ok(cityService.updateImage(id, image));
    }

    @Override
    public ResponseEntity<?> updateImages(Long id, MultipartFile[] image) throws Exception {
        return null;
    }

    @DeleteMapping("/{id}/image")
    @Override
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(cityService.delete(id));
    }

    @Override
    public ResponseEntity<?> deleteImages(Long id) throws Exception {
        return null;
    }
}
