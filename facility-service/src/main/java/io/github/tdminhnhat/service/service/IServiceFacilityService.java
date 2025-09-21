package io.github.tdminhnhat.service.service;

import io.github.tdminhnhat.core.service.IImageService;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.service.model.dto.ServiceDto;
import io.github.tdminhnhat.service.model.qo.ServiceQo;

public interface IServiceFacilityService extends IService<ServiceDto, Long, ServiceQo>, IImageService<Long> {
}
