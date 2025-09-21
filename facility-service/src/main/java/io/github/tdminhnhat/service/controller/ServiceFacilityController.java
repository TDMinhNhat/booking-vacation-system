package io.github.tdminhnhat.service.controller;

import io.github.tdminhnhat.core.controller.IImageManagementController;
import io.github.tdminhnhat.core.controller.IManagementController;
import io.github.tdminhnhat.service.model.dto.ServiceDto;
import io.github.tdminhnhat.service.model.qo.ServiceQo;
import io.github.tdminhnhat.service.service.IServiceFacilityService;
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
@RequestMapping("/api/v1/service")
@RequiredArgsConstructor
public class ServiceFacilityController implements IManagementController<ServiceDto, Long, ServiceQo>, IImageManagementController<Long> {

    private final IServiceFacilityService serviceFacilityService;

    @PostMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<?> addImage(@PathVariable("id") Long id, @RequestParam MultipartFile image) throws Exception {
        return ResponseEntity.ok(serviceFacilityService.addImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> addListImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @PutMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<?> updateImage(@PathVariable("id") Long id, @RequestParam MultipartFile image) throws Exception {
        return ResponseEntity.ok(serviceFacilityService.updateImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> updateImages(Long id, MultipartFile[] image) throws Exception {
        return null;
    }

    @DeleteMapping("/{id}/image")
    @Override
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(serviceFacilityService.deleteImage(id));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> deleteImages(Long id) throws Exception {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<?> add(@Valid @RequestBody ServiceDto entity) {
        return ResponseEntity.ok(serviceFacilityService.add(entity));
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Collection<?>> addList(
            @Valid
            @Size(min = 1, message = "The list must contain at least one item")
            @RequestBody
            Collection<ServiceDto> list) {
        return ResponseEntity.ok(serviceFacilityService.addList(list));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody ServiceDto entity) {
        return ResponseEntity.ok(serviceFacilityService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(serviceFacilityService.delete(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(serviceFacilityService.getById(id));
    }

    @PostMapping("/get-list")
    @Override
    public ResponseEntity<PageImpl<?>> getAll(@Valid @RequestBody ServiceQo filter) {
        return ResponseEntity.ok(serviceFacilityService.getAll(filter));
    }
}
