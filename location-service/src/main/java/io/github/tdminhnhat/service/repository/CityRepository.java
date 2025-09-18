package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.City;
import io.github.tdminhnhat.service.model.qo.CityQo;
import io.github.tdminhnhat.service.model.vo.CityVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query("""
        SELECT new io.github.tdminhnhat.service.model.vo.CityVo(
                ct.id, ct.description, ct.delete, ct.createdAt, ct.updatedAt, ct.createdBy, ct.updatedBy, ct.cityName, ct.imageURL, c
                ) FROM City ct INNER JOIN Country c ON ct.country.id = c.id
        WHERE (:#{#filter.id} IS NULL OR ct.id = :#{#filter.id})
        OR (:#{#filter.cityName} IS NULL OR ct.cityName = :#{#filter.cityName})
        OR (:#{#filter.delete} IS NULL OR ct.delete = :#{#filter.delete})
        OR (:#{#filter.countryCode} IS NULL OR ct.country.countryCode = :#{#filter.countryCode})
        OR (:#{#filter.beginCreatedAt} IS NULL OR :#{#filter.endCreatedAt} IS NULL OR (ct.createdAt >= :#{#filter.beginCreatedAt} AND ct.createdAt <= :#{#filter.endCreatedAt}))
        """)
    Page<CityVo> getCitiesByFilter(@Param("filter") CityQo filter, Pageable pageable);
}
