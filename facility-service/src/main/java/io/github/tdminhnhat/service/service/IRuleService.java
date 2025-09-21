package io.github.tdminhnhat.service.service;

import io.github.tdminhnhat.core.service.IImageService;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.service.model.dto.RuleDto;
import io.github.tdminhnhat.service.model.qo.RuleQo;

public interface IRuleService extends IService<RuleDto, Long, RuleQo>, IImageService<Long> {
}
