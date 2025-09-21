package io.github.tdminhnhat.service.controller;

import io.github.tdminhnhat.core.controller.IImageManagementController;
import io.github.tdminhnhat.core.controller.IManagementController;
import io.github.tdminhnhat.service.entity.Facility;
import io.github.tdminhnhat.service.model.dto.FacilityDto;
import io.github.tdminhnhat.service.model.qo.FacilityQo;
import io.github.tdminhnhat.service.model.vo.FacilityVo;
import io.github.tdminhnhat.service.service.IFacilityService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/facility")
@RequiredArgsConstructor
public class FacilityController implements IManagementController<FacilityDto, Long, FacilityQo>, IImageManagementController<Long> {

    private final IFacilityService facilityService;

    @PostMapping("/{id}/image")
    @Override
    public ResponseEntity<?> addImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) throws Exception {
        return ResponseEntity.ok(facilityService.addImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> addListImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @PutMapping("/{id}/image")
    @Override
    public ResponseEntity<?> updateImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) throws Exception {
        return ResponseEntity.ok(facilityService.updateImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> updateImages(Long id, MultipartFile[] image) throws Exception {
        return null;
    }

    @DeleteMapping("/{id}/image")
    @Override
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(facilityService.deleteImage(id));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> deleteImages(Long id) throws Exception {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<?> add(@Valid @RequestBody FacilityDto entity) {
        return ResponseEntity.ok(facilityService.add(entity));
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Collection<?>> addList(
            @Valid
            @Size(min = 1, message = "The list must contain at least one item")
            @RequestBody
            Collection<FacilityDto> list) {
        return ResponseEntity.ok(facilityService.addList(list));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable("id") Long id,
                                    @Valid @RequestBody FacilityDto entity) {
        return ResponseEntity.ok(facilityService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(facilityService.delete(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(facilityService.getById(id));
    }

    @PostMapping("/get-list")
    @Override
    public ResponseEntity<PageImpl<?>> getAll(@Valid @RequestBody FacilityQo filter) {
        return ResponseEntity.ok(facilityService.getAll(filter));
    }
}
