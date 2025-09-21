package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Facility;
import io.github.tdminhnhat.service.model.qo.FacilityQo;
import io.github.tdminhnhat.service.model.vo.FacilityVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

    @Query("""
        select new io.github.tdminhnhat.service.model.vo.FacilityVo(
                f.id, f.description, f.delete, f.code, f.name, f.imageUrl 
                ) from Facility f
        where (:#{#filter.id} is null or f.id = :#{#filter.id})
        and (:#{#filter.code} is null or f.code = :#{#filter.code})
        and (:#{#filter.name} is null or f.name like %:#{#filter.name}%)
        and (:#{#filter.delete} is null or f.delete = :#{#filter.delete})
        and (:#{#filter.beginCreatedAt} is null or :#{#filter.endCreatedAt} is null or (f.createdAt >= :#{#filter.beginCreatedAt} and f.createdAt <= :#{#filter.endCreatedAt}))
        and (:#{#filter.beginUpdatedAt} is null or :#{#filter.endUpdatedAt} is null or (f.updatedAt >= :#{#filter.beginUpdatedAt} and f.updatedAt <= :#{#filter.endUpdatedAt}))
        and (:#{#filter.createdBy} is null or f.createdBy = :#{#filter.createdBy})
        and (:#{#filter.updatedBy} is null or f.updatedBy = :#{#filter.updatedBy})
        and (:#{#filter.delete} is null or f.delete = :#{#filter.delete})
        order by f.updatedAt desc, f.createdAt desc
        """)
    Page<FacilityVo> getAllFacilitiesByFilter(@Param("filter") FacilityQo filter, Pageable pageable);
}
