package io.github.tdminhnhat.service.controller;

import io.github.tdminhnhat.core.controller.IImageManagementController;
import io.github.tdminhnhat.core.controller.IManagementController;
import io.github.tdminhnhat.service.model.dto.UserRegisterDto;
import io.github.tdminhnhat.service.model.qo.UserQo;
import io.github.tdminhnhat.service.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController implements IManagementController<UserRegisterDto, Long, UserQo>, IImageManagementController<Long> {

    private final IUserService userService;

    @Override
    public ResponseEntity<?> addImage(Long id, MultipartFile image) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> addListImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> updateImage(Long id, MultipartFile image) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> updateImages(Long id, MultipartFile[] image) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteImage(Long id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteImages(Long id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> add(UserRegisterDto entity) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<?>> addList(Collection<UserRegisterDto> list) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(Long id, UserRegisterDto entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PageImpl<?>> getAll(UserQo filter) {
        return null;
    }
}
