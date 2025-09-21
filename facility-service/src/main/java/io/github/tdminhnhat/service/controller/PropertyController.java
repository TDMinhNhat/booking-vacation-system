package io.github.tdminhnhat.service.controller;

import io.github.tdminhnhat.core.controller.IImageManagementController;
import io.github.tdminhnhat.core.controller.IManagementController;
import io.github.tdminhnhat.service.model.dto.PropertyDto;
import io.github.tdminhnhat.service.model.qo.PropertyQo;
import io.github.tdminhnhat.service.service.IPropertyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/property")
@RequiredArgsConstructor
public class PropertyController implements IManagementController<PropertyDto, Long, PropertyQo>, IImageManagementController<Long> {

    private final IPropertyService propertyService;

    @PostMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<?> addImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) throws Exception {
        return ResponseEntity.ok(propertyService.addImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> addListImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @PutMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<?> updateImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) throws Exception {
        return ResponseEntity.ok(propertyService.updateImage(id, image));
    }

    @Override
    public ResponseEntity<?> updateImages(Long id, MultipartFile[] image) throws Exception {
        return null;
    }

    @DeleteMapping("/{id}/image")
    @Override
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(propertyService.deleteImage(id));
    }

    @Override
    public ResponseEntity<?> deleteImages(Long id) throws Exception {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<?> add(@Valid @RequestBody PropertyDto entity) {
        return ResponseEntity.ok(propertyService.add(entity));
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Collection<?>> addList(
            @Valid
            @Size(min = 1, message = "The list must contain at least one item")
            @RequestBody Collection<PropertyDto> list) {
        return ResponseEntity.ok(propertyService.addList(list));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody PropertyDto entity) {
        return ResponseEntity.ok(propertyService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(propertyService.delete(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(propertyService.getById(id));
    }

    @PostMapping("/get-list")
    @Override
    public ResponseEntity<PageImpl<?>> getAll(@Valid @RequestBody PropertyQo filter) {
        return ResponseEntity.ok(propertyService.getAll(filter));
    }
}
