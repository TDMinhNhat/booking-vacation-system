package io.github.tdminhnhat.service.service.impl;

import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.github.tdminhnhat.service.entity.Country;
import io.github.tdminhnhat.service.model.dto.CountryDto;
import io.github.tdminhnhat.service.model.qo.CountryQo;
import io.github.tdminhnhat.service.repository.CountryRepository;
import io.github.tdminhnhat.service.service.ICountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements ICountryService {

    private final CountryRepository countryRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object add(CountryDto entity) {
        Country country = new Country();
        BeanUtils.copyProperties(entity, country);
        return countryRepository.save(country);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Collection<Object> addList(Collection<CountryDto> list) {
        return Collections.singleton(countryRepository.saveAll(list.stream().map(countryDto -> {
            Country country = new Country();
            BeanUtils.copyProperties(countryDto, country);
            return country;
        }).toList()));
    }

    @Override
    public Object update(String id, CountryDto entity) {
        Country country = countryRepository.findCountryByCountryCode(id).orElseThrow(() -> new QueryNotFoundException("countryCode = " + id + " wasn't found in database"));
        BeanUtils.copyProperties(entity, country, "id", "createdAt", "createdBy");
        return countryRepository.save(country);
    }

    @Override
    public Object delete(String id) {
        Country country = countryRepository.findCountryByCountryCode(id).orElseThrow(() -> new QueryNotFoundException("countryCode = " + id + " wasn't found in database"));
        country.setDelete(true);
        return countryRepository.save(country);
    }

    @Override
    public Object getById(String id) {
        return countryRepository.findCountryByCountryCode(id).orElseThrow(() -> new QueryNotFoundException("countryCode = " + id + " wasn't found in database"));
    }

    @Override
    public PageImpl<Country> getAll(CountryQo filter) {
        Page<Country> page = countryRepository.getCountriesByFilter(filter, filter.pageRequest().getPageable());
        return new PageImpl<>(page.getContent(), page.getPageable(), page.getTotalElements());
    }
}
