package io.github.tdminhnhat.service.service;

import io.github.tdminhnhat.core.service.IImageService;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.service.model.dto.CountryDto;
import io.github.tdminhnhat.service.model.qo.CountryQo;

public interface ICountryService extends IService<CountryDto, String, CountryQo>, IImageService<String> {
}
