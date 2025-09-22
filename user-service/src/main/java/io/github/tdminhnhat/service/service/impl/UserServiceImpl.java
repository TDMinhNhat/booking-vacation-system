package io.github.tdminhnhat.service.service.impl;

import io.github.tdminhnhat.core.exception.InvalidImageFileException;
import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.github.tdminhnhat.core.util.MinioUtil;
import io.github.tdminhnhat.core.util.ValidateImageUtil;
import io.github.tdminhnhat.service.entity.User;
import io.github.tdminhnhat.service.model.dto.UserRegisterDto;
import io.github.tdminhnhat.service.model.qo.UserQo;
import io.github.tdminhnhat.service.model.vo.UserVo;
import io.github.tdminhnhat.service.repository.UserRepository;
import io.github.tdminhnhat.service.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final MinioUtil minioUtil;

    @Override
    public Object addImage(Long id, MultipartFile image) throws Exception {
        if(ValidateImageUtil.isImageFile(image)) {
            User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User not found"));
            minioUtil.uploadFile("/user/", image.getResource().getFilename(), image);
            user.setAddress("/user/" + image.getResource().getFilename());
            return userRepository.save(user);
        }
        throw new InvalidImageFileException();
    }

    @Override
    public Object addListImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @Override
    public Object updateImage(Long id, MultipartFile image) throws Exception {
        if(ValidateImageUtil.isImageFile(image)) {
            User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User not found"));
            this.deleteImage(id);
            minioUtil.uploadFile("/user/", image.getResource().getFilename(), image);
            user.setAvatar("/user/" + image.getResource().getFilename());
            return userRepository.save(user);
        }
        throw new InvalidImageFileException();
    }

    @Override
    public Object updateImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @Override
    public Object deleteImage(Long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User not found"));
        if(user.getAvatar() != null) {
            minioUtil.deleteFile(null, user.getAvatar());
            user.setAvatar(null);
            return userRepository.save(user);
        }
        return user;
    }

    @Override
    public Object deleteImages(Long id) throws Exception {
        return null;
    }

    @Override
    public Object add(UserRegisterDto entity) {
        User user = new User();
        BeanUtils.copyProperties(entity, user);
        return userRepository.save(user);
    }

    @Override
    public Collection<Object> addList(Collection<UserRegisterDto> list) {
        return List.of();
    }

    @Override
    public Object update(Long id, UserRegisterDto entity) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User not found"));
        BeanUtils.copyProperties(entity, user);
        return userRepository.save(user);
    }

    @Override
    public Object delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User not found"));
        user.setDelete(true);
        return userRepository.save(user);
    }

    @Override
    public Object getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User not found"));
    }

    @Override
    public PageImpl<UserVo> getAll(UserQo filter) {
        Page<UserVo> userVoPage = userRepository.getAllUsersByFilter(filter, filter.pageRequest().getPageable());
        return new PageImpl<>(userVoPage.getContent(), userVoPage.getPageable(), userVoPage.getTotalElements());
    }
}
