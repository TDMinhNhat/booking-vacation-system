package io.github.tdminhnhat.service.service.impl;

import io.github.tdminhnhat.service.model.dto.UserRegisterDto;
import io.github.tdminhnhat.service.model.qo.UserQo;
import io.github.tdminhnhat.service.repository.UserRepository;
import io.github.tdminhnhat.service.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public Object addImage(Long id, MultipartFile image) throws Exception {
        return null;
    }

    @Override
    public Object addListImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @Override
    public Object updateImage(Long id, MultipartFile image) throws Exception {
        return null;
    }

    @Override
    public Object updateImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @Override
    public Object deleteImage(Long id) throws Exception {
        return null;
    }

    @Override
    public Object deleteImages(Long id) throws Exception {
        return null;
    }

    @Override
    public Object add(UserRegisterDto entity) {
        return null;
    }

    @Override
    public Collection<Object> addList(Collection<UserRegisterDto> list) {
        return List.of();
    }

    @Override
    public Object update(Long id, UserRegisterDto entity) {
        return null;
    }

    @Override
    public Object delete(Long id) {
        return null;
    }

    @Override
    public Object getById(Long id) {
        return null;
    }

    @Override
    public PageImpl<?> getAll(UserQo filter) {
        return null;
    }
}
