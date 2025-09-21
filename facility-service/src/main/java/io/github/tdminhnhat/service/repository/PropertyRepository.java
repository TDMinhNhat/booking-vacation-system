package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Property;
import io.github.tdminhnhat.service.model.qo.PropertyQo;
import io.github.tdminhnhat.service.model.vo.PropertyVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("""
        select new io.github.tdminhnhat.service.model.vo.PropertyVo(
            p.id, p.description, p.delete, p.name, p.imageUrl) from Property p
        where (:#{#filter.id} is null or p.id = :#{#filter.id})
        and (:#{#filter.name} is null or p.name like %:#{#filter.name}%)
        and (:#{#filter.delete} is null or p.delete = :#{#filter.delete})
        and (:#{#filter.beginCreatedAt} is null or :#{#filter.endCreatedAt} is null or (p.createdAt >= :#{#filter.beginCreatedAt} and p.createdAt <= :#{#filter.endCreatedAt}))
        and (:#{#filter.beginUpdatedAt} is null or :#{#filter.endUpdatedAt} is null or (p.updatedAt >= :#{#filter.beginUpdatedAt} and p.updatedAt <= :#{#filter.endUpdatedAt}))
        and (:#{#filter.createdBy} is null or p.createdBy like %:#{#filter.createdBy}%)
        and (:#{#filter.updatedBy} is null or p.updatedBy like %:#{#filter.updatedBy}%)
        order by p.updatedAt desc, p.createdAt desc
    """)
    Page<PropertyVo> getAllPropertiesByFilter(@Param("filter") PropertyQo filter, Pageable pageable);
}
