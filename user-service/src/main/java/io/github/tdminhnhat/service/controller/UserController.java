package io.github.tdminhnhat.service.controller;

import io.github.tdminhnhat.core.controller.IImageManagementController;
import io.github.tdminhnhat.core.controller.IManagementController;
import io.github.tdminhnhat.service.model.dto.UserRegisterDto;
import io.github.tdminhnhat.service.model.qo.UserQo;
import io.github.tdminhnhat.service.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController implements IManagementController<UserRegisterDto, Long, UserQo>, IImageManagementController<Long> {

    private final IUserService userService;

    @PostMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<?> addImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) throws Exception {
        return ResponseEntity.ok(userService.addImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> addListImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @PutMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<?> updateImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) throws Exception {
        return ResponseEntity.ok(userService.updateImage(id, image));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> updateImages(Long id, MultipartFile[] image) throws Exception {
        return null;
    }

    @DeleteMapping("/{id}/image")
    @Override
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(userService.deleteImage(id));
    }

    @Deprecated
    @Override
    public ResponseEntity<?> deleteImages(Long id) throws Exception {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<?> add(@Valid @RequestBody UserRegisterDto entity) {
        return ResponseEntity.ok(userService.add(entity));
    }

    @Deprecated
    @Override
    public ResponseEntity<Collection<?>> addList(Collection<UserRegisterDto> list) {
        return null;
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody UserRegisterDto entity) {
        return ResponseEntity.ok(userService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/get-list")
    @Override
    public ResponseEntity<PageImpl<?>> getAll(@Valid @RequestBody UserQo filter) {
        return ResponseEntity.ok(userService.getAll(filter));
    }
}
