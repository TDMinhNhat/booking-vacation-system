package io.github.tdminhnhat.service.mapper;

import io.github.tdminhnhat.service.entity.Facility;
import io.github.tdminhnhat.service.model.vo.FacilityVo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FacilityMapper {
    Facility toEntity(FacilityVo facilityVo);

    FacilityVo toDto(Facility facility);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Facility partialUpdate(FacilityVo facilityVo, @MappingTarget Facility facility);
}