package io.github.tdminhnhat.service.mapper;

import io.github.tdminhnhat.service.entity.Property;
import io.github.tdminhnhat.service.model.vo.PropertyVo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PropertyMapper {
    Property toEntity(PropertyVo propertyVo);

    PropertyVo toDto(Property property);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Property partialUpdate(PropertyVo propertyVo, @MappingTarget Property property);
}