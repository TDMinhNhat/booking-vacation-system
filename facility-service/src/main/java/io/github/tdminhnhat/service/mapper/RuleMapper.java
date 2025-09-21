package io.github.tdminhnhat.service.mapper;

import io.github.tdminhnhat.service.entity.Rule;
import io.github.tdminhnhat.service.model.vo.RuleVo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RuleMapper {
    Rule toEntity(RuleVo ruleVo);

    RuleVo toDto(Rule rule);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rule partialUpdate(RuleVo ruleVo, @MappingTarget Rule rule);
}