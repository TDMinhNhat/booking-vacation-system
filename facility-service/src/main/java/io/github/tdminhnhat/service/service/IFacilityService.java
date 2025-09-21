package io.github.tdminhnhat.service.service;

import io.github.tdminhnhat.core.service.IImageService;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.service.model.dto.FacilityDto;
import io.github.tdminhnhat.service.model.qo.FacilityQo;

public interface IFacilityService extends IService<FacilityDto, Long, FacilityQo>, IImageService<Long> {
}
