package io.github.tdminhnhat.service.service;

import io.github.tdminhnhat.core.service.IImageService;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.service.model.dto.UserRegisterDto;
import io.github.tdminhnhat.service.model.qo.UserQo;

public interface IUserService extends IService<UserRegisterDto, Long, UserQo>, IImageService<Long> {
}
