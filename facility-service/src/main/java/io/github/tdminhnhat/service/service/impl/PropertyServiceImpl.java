package io.github.tdminhnhat.service.service.impl;

import io.github.tdminhnhat.core.exception.InvalidImageFileException;
import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.github.tdminhnhat.core.util.MinioUtil;
import io.github.tdminhnhat.core.util.ValidateImageUtil;
import io.github.tdminhnhat.service.entity.Property;
import io.github.tdminhnhat.service.model.dto.PropertyDto;
import io.github.tdminhnhat.service.model.qo.PropertyQo;
import io.github.tdminhnhat.service.model.vo.PropertyVo;
import io.github.tdminhnhat.service.repository.PropertyRepository;
import io.github.tdminhnhat.service.service.IPropertyService;
import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements IPropertyService {

    private final PropertyRepository propertyRepository;
    private final MinioUtil minioUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object addImage(Long id, MultipartFile image) throws Exception {
        if(ValidateImageUtil.isImageFile(image)) {
            Property property = propertyRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Property not found"));
            minioUtil.uploadFile("/property/", image.getResource().getFilename(), image);
            property.setImageUrl("/property/" + image.getResource().getFilename());
            return propertyRepository.save(property);
        }
        throw new InvalidImageFileException();
    }

    @Override
    public Object addListImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object updateImage(Long id, MultipartFile image) throws Exception {
        if(ValidateImageUtil.isImageFile(image)) {
            Property property = propertyRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Property not found"));
            this.deleteImage(id);
            minioUtil.uploadFile("/facility/property/", image.getResource().getFilename(), image);
            property.setImageUrl("/facility/property/" + image.getResource().getFilename());
            return propertyRepository.save(property);
        }
        throw new InvalidImageFileException();
    }

    @Override
    public Object updateImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object deleteImage(Long id) throws Exception {
        Property property = propertyRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Property not found"));
        if(property.getImageUrl() != null) {
            minioUtil.deleteFile(null, property.getImageUrl());
            property.setImageUrl(null);
            return propertyRepository.save(property);
        }
        return property;
    }

    @Override
    public Object deleteImages(Long id) throws Exception {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object add(PropertyDto entity) {
        Property property = new Property();
        BeanUtils.copyProperties(entity, property);
        return propertyRepository.save(property);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Collection<Object> addList(Collection<PropertyDto> list) {
        return list.stream().map(this::add).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object update(Long id, PropertyDto entity) {
        Property property = propertyRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Property not found"));
        BeanUtils.copyProperties(entity, property);
        return propertyRepository.save(property);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object delete(Long id) {
        Property property = propertyRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Property not found"));
        property.setDelete(true);
        return propertyRepository.save(property);
    }

    @Override
    public Object getById(Long id) {
        return propertyRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Property not found"));
    }

    @Override
    public PageImpl<PropertyVo> getAll(PropertyQo filter) {
        Page<PropertyVo> propertyVoPage = propertyRepository.getAllPropertiesByFilter(filter, filter.pageRequest().getPageable());
        return new PageImpl<>(propertyVoPage.getContent(), propertyVoPage.getPageable(), propertyVoPage.getTotalElements());
    }
}
