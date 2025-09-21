package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Service;
import io.github.tdminhnhat.service.model.qo.ServiceQo;
import io.github.tdminhnhat.service.model.vo.ServiceVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query("""
        select new io.github.tdminhnhat.service.model.vo.ServiceVo(
            s.id, s.description, s.delete, s.code, s.serviceType, s.name, s.imageUrl
            ) from Service s
        where (:#{#filter.id} is null or s.id = :#{#filter.id})
        and (:#{#filter.name} is null or s.name like %:#{#filter.name}%)
        and (:#{#filter.code} is null or s.code like %:#{#filter.code}%)
        and (:#{#filter.delete} is null or s.delete = :#{#filter.delete})
        and (:#{#filter.beginCreatedAt} is null or :#{#filter.endCreatedAt} is null or (s.createdAt >= :#{#filter.beginCreatedAt} and s.createdAt <= :#{#filter.endCreatedAt}))
        and (:#{#filter.beginUpdatedAt} is null or :#{#filter.endUpdatedAt} is null or (s.updatedAt >= :#{#filter.beginUpdatedAt} and s.updatedAt <= :#{#filter.endUpdatedAt}))
        and (:#{#filter.createdBy} is null or s.createdBy like %:#{#filter.createdBy}%)
        and (:#{#filter.updatedBy} is null or s.updatedBy like %:#{#filter.updatedBy}%)
    """)
    Page<ServiceVo> getAllServicesByFilter(@Param("filter") ServiceQo filter, Pageable pageable);
}
