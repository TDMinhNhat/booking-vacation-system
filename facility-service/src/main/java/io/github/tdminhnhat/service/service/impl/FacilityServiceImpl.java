package io.github.tdminhnhat.service.service.impl;

import io.github.tdminhnhat.core.exception.InvalidImageFileException;
import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.github.tdminhnhat.core.util.MinioUtil;
import io.github.tdminhnhat.core.util.ValidateImageUtil;
import io.github.tdminhnhat.service.entity.Facility;
import io.github.tdminhnhat.service.model.dto.FacilityDto;
import io.github.tdminhnhat.service.model.qo.FacilityQo;
import io.github.tdminhnhat.service.model.vo.FacilityVo;
import io.github.tdminhnhat.service.repository.FacilityRepository;
import io.github.tdminhnhat.service.service.IFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements IFacilityService {

    private final FacilityRepository facilityRepository;
    private final MinioUtil minioUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object addImage(Long id, MultipartFile image) throws Exception {
        if(ValidateImageUtil.isImageFile(image)) {
            Facility facility = facilityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Facility not found"));
            minioUtil.uploadFile("/facility/", image.getResource().getFilename(), image);
            facility.setImageUrl("/facility/" + image.getResource().getFilename());
            return facilityRepository.save(facility);
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
            Facility facility = facilityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Facility not found"));
            this.delete(id);
            minioUtil.uploadFile("/facility/", image.getResource().getFilename(), image);
            facility.setImageUrl("/facility/" + image.getResource().getFilename());
            return facilityRepository.save(facility);
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
        Facility facility = facilityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Facility not found"));
        if(facility.getImageUrl() != null) {
            minioUtil.deleteFile(null, facility.getImageUrl());
            facility.setImageUrl(null);
            return facilityRepository.save(facility);
        }
        return facility;
    }

    @Override
    public Object deleteImages(Long id) throws Exception {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object add(FacilityDto entity) {
        Facility facility = new Facility();
        BeanUtils.copyProperties(entity, facility);
        return facilityRepository.save(facility);
    }

    @Override
    public Collection<Object> addList(Collection<FacilityDto> list) {
        return List.of();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object update(Long id, FacilityDto entity) {
        Facility facility = facilityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Facility not found"));
        BeanUtils.copyProperties(entity, facility);
        return facilityRepository.save(facility);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object delete(Long id) {
        Facility facility = facilityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Facility not found"));
        facility.setDelete(true);
        return facilityRepository.save(facility);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object getById(Long id) {
        return facilityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Facility not found"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageImpl<FacilityVo> getAll(FacilityQo filter) {
        Page<FacilityVo> facilityVoPage = facilityRepository.getAllFacilitiesByFilter(filter, filter.pageRequest().getPageable());
        return new PageImpl<>(facilityVoPage.getContent(), facilityVoPage.getPageable(), facilityVoPage.getTotalElements());
    }
}
