package io.github.tdminhnhat.service.service.impl;

import io.github.tdminhnhat.core.exception.InvalidImageFileException;
import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.github.tdminhnhat.core.util.MinioUtil;
import io.github.tdminhnhat.core.util.ValidateImageUtil;
import io.github.tdminhnhat.service.entity.Service;
import io.github.tdminhnhat.service.model.dto.ServiceDto;
import io.github.tdminhnhat.service.model.qo.ServiceQo;
import io.github.tdminhnhat.service.model.vo.ServiceVo;
import io.github.tdminhnhat.service.repository.ServiceRepository;
import io.github.tdminhnhat.service.service.IServiceFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceFacilityServiceImpl implements IServiceFacilityService {

    private final ServiceRepository serviceRepository;
    private final MinioUtil minioUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object addImage(Long id, MultipartFile image) throws Exception {
        if(ValidateImageUtil.isImageFile(image)) {
            Service service = serviceRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Service not found with id: " + id));
            minioUtil.uploadFile("/service/", image.getResource().getFilename(), image);
            service.setImageUrl("/service/" + image.getResource().getFilename());
            return serviceRepository.save(service);
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
            Service service = serviceRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Service not found with id: " + id));
            this.delete(id);
            minioUtil.uploadFile("/service/", image.getResource().getFilename(), image);
            service.setImageUrl("/service/" + image.getResource().getFilename());
            return serviceRepository.save(service);
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
        Service service = serviceRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Service not found with id: " + id));
        if(service.getImageUrl() != null) {
            minioUtil.deleteFile(null, service.getImageUrl());
            service.setImageUrl(null);
            return serviceRepository.save(service);
        }
        return service;
    }

    @Override
    public Object deleteImages(Long id) throws Exception {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object add(ServiceDto entity) {
        Service service = new Service();
        BeanUtils.copyProperties(entity, service);
        return serviceRepository.save(service);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Collection<Object> addList(Collection<ServiceDto> list) {
        return list.stream().map(this::add).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object update(Long id, ServiceDto entity) {
        Service service = serviceRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Service not found with id: " + id));
        BeanUtils.copyProperties(entity, service);
        return serviceRepository.save(service);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object delete(Long id) {
        Service service = serviceRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Service not found with id: " + id));
        service.setDelete(true);
        return serviceRepository.save(service);
    }

    @Override
    public Object getById(Long id) {
        return serviceRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Service not found with id: " + id));
    }

    @Override
    public PageImpl<ServiceVo> getAll(ServiceQo filter) {
        Page<ServiceVo> serviceVoPage = serviceRepository.getAllServicesByFilter(filter, filter.pageRequest().getPageable());
        return new PageImpl<>(serviceVoPage.getContent(), serviceVoPage.getPageable(), serviceVoPage.getTotalElements());
    }
}
