package io.github.tdminhnhat.service.service.impl;

import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.github.tdminhnhat.core.util.MinioUtil;
import io.github.tdminhnhat.service.entity.City;
import io.github.tdminhnhat.service.entity.Country;
import io.github.tdminhnhat.service.model.dto.CityDto;
import io.github.tdminhnhat.service.model.qo.CityQo;
import io.github.tdminhnhat.service.model.vo.CityVo;
import io.github.tdminhnhat.service.repository.CityRepository;
import io.github.tdminhnhat.service.repository.CountryRepository;
import io.github.tdminhnhat.service.service.ICityService;
import io.github.tdminhnhat.core.util.ValidateImageUtil;
import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements ICityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final MinioUtil minioUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object add(CityDto entity) {
        Country country = countryRepository.findCountryByCountryCode(entity.countryCode()).orElseThrow(() -> new QueryNotFoundException("countryCode = " + entity.countryCode() + " wasn't found in database"));
        City city = new City();
        BeanUtils.copyProperties(entity, city, "id", "countryCode");
        city.setCountry(country);
        return cityRepository.save(city);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Collection<Object> addList(Collection<CityDto> list) {
        return Collections.singleton(list.stream().map(cityDto -> {
            Country country = countryRepository.findCountryByCountryCode(cityDto.countryCode()).orElseThrow(() -> new QueryNotFoundException("countryCode = " + cityDto.countryCode() + " wasn't found in database"));
            City city = new City();
            BeanUtils.copyProperties(cityDto, city, "id", "countryCode");
            city.setCountry(country);
            return cityRepository.save(city);
        }).toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object update(Long id, CityDto entity) {
        City city = cityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("cityId = " + id + " wasn't found in database"));
        BeanUtils.copyProperties(entity, city, "id", "createdAt", "createdBy", "countryCode");
        if(entity.countryCode() != null) {
            Country country = countryRepository.findCountryByCountryCode(entity.countryCode()).orElseThrow(() -> new QueryNotFoundException("countryCode = " + entity.countryCode() + " wasn't found in database"));
            city.setCountry(country);
        }
        return cityRepository.save(city);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object delete(Long id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("cityId = " + id + " wasn't found in database"));
        city.setDelete(true);
        return cityRepository.save(city);
    }

    @Override
    public Object getById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("cityId = " + id + " wasn't found in database"));
    }

    @Override
    public PageImpl<CityVo> getAll(CityQo filter) {
        Page<CityVo> cityVoPage = cityRepository.getCitiesByFilter(filter, filter.pageRequest().getPageable());
        return new PageImpl<>(cityVoPage.getContent(), cityVoPage.getPageable(), cityVoPage.getTotalElements());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object addImage(Long id, MultipartFile image) throws Exception {
        if(!ValidateImageUtil.isImageFile(image)) {
            throw new BadRequestException("Only accept file with image type: png, jpg, jpeg");
        }
        City city = cityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("cityId = " + id + " wasn't found in database"));
        city.setImageURL("/city/" + image.getResource().getFilename());
        minioUtil.uploadFile("/city/", image.getResource().getFilename(), image);
        return cityRepository.save(city);
    }

    @Override
    public Object addListImages(Long id, MultipartFile[] images) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object updateImage(Long id, MultipartFile image) throws Exception {
        if(!ValidateImageUtil.isImageFile(image)) {
            throw new BadRequestException("Only accept file with image type: png, jpg, jpeg");
        }
        City city = cityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("cityId = " + id + " wasn't found in database"));
        if(city.getImageURL() == null) {
            return addImage(id, image);
        }
        minioUtil.deleteFile(null, city.getImageURL());
        minioUtil.uploadFile("/city/", image.getResource().getFilename(), image);
        city.setImageURL("/city/" + image.getResource().getFilename());
        return null;
    }

    @Deprecated
    @Override
    public Object updateImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object deleteImage(Long id) throws Exception {
        City city = cityRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("cityId = " + id + " wasn't found in database"));
        if(city.getImageURL() != null) {
            minioUtil.deleteFile(null, city.getImageURL());
            city.setImageURL(null);
            return cityRepository.save(city);
        }
        throw new BadRequestException("City doesn't have any image to delete");
    }

    @Deprecated
    @Override
    public Object deleteImages(Long id) throws Exception {
        return null;
    }
}
