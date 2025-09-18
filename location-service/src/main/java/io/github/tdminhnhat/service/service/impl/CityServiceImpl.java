package io.github.tdminhnhat.service.service.impl;

import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.github.tdminhnhat.service.entity.City;
import io.github.tdminhnhat.service.entity.Country;
import io.github.tdminhnhat.service.model.dto.CityDto;
import io.github.tdminhnhat.service.model.qo.CityQo;
import io.github.tdminhnhat.service.model.vo.CityVo;
import io.github.tdminhnhat.service.repository.CityRepository;
import io.github.tdminhnhat.service.repository.CountryRepository;
import io.github.tdminhnhat.service.service.ICityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements ICityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

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
}
