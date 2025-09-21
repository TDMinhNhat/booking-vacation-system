package io.github.tdminhnhat.service.service;

import io.github.tdminhnhat.core.service.IImageService;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.service.model.dto.PropertyDto;
import io.github.tdminhnhat.service.model.qo.PropertyQo;

public interface IPropertyService extends IService<PropertyDto, Long, PropertyQo>, IImageService<Long> {
}
