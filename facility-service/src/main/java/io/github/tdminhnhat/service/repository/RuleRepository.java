package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Rule;
import io.github.tdminhnhat.service.model.qo.PropertyQo;
import io.github.tdminhnhat.service.model.qo.RuleQo;
import io.github.tdminhnhat.service.model.vo.RuleVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RuleRepository extends JpaRepository<Rule, Long> {

    @Query("""
        select new io.github.tdminhnhat.service.model.vo.RuleVo(
            r.id, r.description, r.delete, r.code, r.name, r.imageUrl
            ) from Rule r
        where (:#{#filter.id} is null or r.id = :#{#filter.id})
        and (:#{#filter.name} is null or r.name like %:#{#filter.name}%)
        and (:#{#filter.code} is null or r.code like %:#{#filter.code}%)
        and (:#{#filter.delete} is null or r.delete = :#{#filter.delete})
        and (:#{#filter.beginCreatedAt} is null or :#{#filter.endCreatedAt} is null or (r.createdAt >= :#{#filter.beginCreatedAt} and r.createdAt <= :#{#filter.endCreatedAt}))
        and (:#{#filter.beginUpdatedAt} is null or :#{#filter.endUpdatedAt} is null or (r.updatedAt >= :#{#filter.beginUpdatedAt} and r.updatedAt <= :#{#filter.endUpdatedAt}))
        and (:#{#filter.createdBy} is null or r.createdBy like %:#{#filter.createdBy}%)
        and (:#{#filter.updatedBy} is null or r.updatedBy like %:#{#filter.updatedBy}%)
    """)
    Page<RuleVo> getAllRulesByFiler(@Param("filter") RuleQo filter, Pageable pageable);
}
