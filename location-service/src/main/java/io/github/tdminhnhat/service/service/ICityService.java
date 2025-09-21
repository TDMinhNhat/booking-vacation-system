package io.github.tdminhnhat.service.service;

import io.github.tdminhnhat.core.service.IImageService;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.service.model.dto.CityDto;
import io.github.tdminhnhat.service.model.qo.CityQo;

public interface ICityService extends IService<CityDto, Long, CityQo>, IImageService<Long> {
}
