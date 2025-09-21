package io.github.tdminhnhat.service.controller;

import io.github.tdminhnhat.core.controller.IImageManagementController;
import io.github.tdminhnhat.core.controller.IManagementController;
import io.github.tdminhnhat.service.model.dto.RuleDto;
import io.github.tdminhnhat.service.model.qo.RuleQo;
import io.github.tdminhnhat.service.service.IRuleService;
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
@RequestMapping("/api/v1/rule")
@RequiredArgsConstructor
public class RuleController implements IManagementController<RuleDto, Long, RuleQo>, IImageManagementController<Long> {

    private final IRuleService ruleService;

    @PostMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<?> addImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) throws Exception {
        return ResponseEntity.ok(ruleService.addImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> addListImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @PutMapping("/{id}/image")
    @Override
    public ResponseEntity<?> updateImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) throws Exception {
        return ResponseEntity.ok(ruleService.updateImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> updateImages(Long id, MultipartFile[] image) throws Exception {
        return null;
    }

    @DeleteMapping("/{id}/image")
    @Override
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(ruleService.deleteImage(id));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> deleteImages(Long id) throws Exception {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<?> add(@Valid @RequestBody RuleDto entity) {
        return ResponseEntity.ok(ruleService.add(entity));
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Collection<?>> addList(
            @Valid
            @Size(min = 1, message = "The list must contain at least one item")
            @RequestBody Collection<RuleDto> list) {
        return ResponseEntity.ok(ruleService.addList(list));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody RuleDto entity) {
        return ResponseEntity.ok(ruleService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ruleService.delete(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ruleService.getById(id));
    }

    @PostMapping("/get-list")
    @Override
    public ResponseEntity<PageImpl<?>> getAll(@Valid @RequestBody RuleQo filter) {
        return ResponseEntity.ok(ruleService.getAll(filter));
    }
}
