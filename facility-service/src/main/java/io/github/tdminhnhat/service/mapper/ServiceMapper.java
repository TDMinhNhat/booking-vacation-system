package io.github.tdminhnhat.service.mapper;

import io.github.tdminhnhat.service.entity.Service;
import io.github.tdminhnhat.service.model.vo.ServiceVo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ServiceMapper {
    Service toEntity(ServiceVo serviceVo);

    ServiceVo toDto(Service service);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Service partialUpdate(ServiceVo serviceVo, @MappingTarget Service service);
}