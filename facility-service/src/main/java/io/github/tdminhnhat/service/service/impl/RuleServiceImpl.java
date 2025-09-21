package io.github.tdminhnhat.service.service.impl;

import io.github.tdminhnhat.core.exception.InvalidImageFileException;
import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.github.tdminhnhat.core.util.MinioUtil;
import io.github.tdminhnhat.core.util.ValidateImageUtil;
import io.github.tdminhnhat.service.entity.Rule;
import io.github.tdminhnhat.service.model.dto.RuleDto;
import io.github.tdminhnhat.service.model.qo.RuleQo;
import io.github.tdminhnhat.service.model.vo.RuleVo;
import io.github.tdminhnhat.service.repository.RuleRepository;
import io.github.tdminhnhat.service.service.IRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleServiceImpl implements IRuleService {

    private final RuleRepository ruleRepository;
    private final MinioUtil minioUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object addImage(Long id, MultipartFile image) throws Exception {
        if(ValidateImageUtil.isImageFile(image)) {
            Rule rule = ruleRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Rule not found"));
            minioUtil.uploadFile("/rule/", image.getResource().getFilename(), image);
            rule.setImageUrl("/rule/" + image.getResource().getFilename());
            return ruleRepository.save(rule);
        }
        throw new InvalidImageFileException();
    }

    @Override
    public Object addListImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object updateImage(Long id, MultipartFile image) throws Exception {
        if(ValidateImageUtil.isImageFile(image)) {
            Rule rule = ruleRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Rule not found"));
            this.deleteImage(id);
            minioUtil.uploadFile("/rule/", image.getResource().getFilename(), image);
            rule.setImageUrl("/rule/" + image.getResource().getFilename());
            return ruleRepository.save(rule);
        }
        throw new InvalidImageFileException();
    }

    @Override
    public Object updateImages(Long id, MultipartFile[] images) throws Exception {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object deleteImage(Long id) throws Exception {
        Rule rule = ruleRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Rule not found"));
        if(rule.getImageUrl() != null) {
            minioUtil.deleteFile(null, rule.getImageUrl());
            rule.setImageUrl(null);
            return ruleRepository.save(rule);

        }
        return rule;
    }

    @Override
    public Object deleteImages(Long id) throws Exception {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object add(RuleDto entity) {
        Rule rule = new Rule();
        BeanUtils.copyProperties(entity, rule);
        return ruleRepository.save(rule);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Collection<Object> addList(Collection<RuleDto> list) {
        return list.stream().map(this::add).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object update(Long id, RuleDto entity) {
        Rule rule = ruleRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Rule not found"));
        BeanUtils.copyProperties(entity, rule);
        return ruleRepository.save(rule);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object delete(Long id) {
        Rule rule = ruleRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Rule not found"));
        rule.setDelete(true);
        return ruleRepository.save(rule);
    }

    @Override
    public Object getById(Long id) {
        return ruleRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Rule not found"));
    }

    @Override
    public PageImpl<RuleVo> getAll(RuleQo filter) {
        Page<RuleVo> ruleVoPage = ruleRepository.getAllRulesByFiler(filter, filter.pageRequest().getPageable());
        return new PageImpl<>(ruleVoPage.getContent(), ruleVoPage.getPageable(), ruleVoPage.getTotalElements());
    }
}
