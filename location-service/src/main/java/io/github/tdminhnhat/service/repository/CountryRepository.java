package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.Country;
import io.github.tdminhnhat.service.model.qo.CountryQo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("""
        SELECT c FROM Country c
        WHERE (:#{#filter.id} IS NULL OR :#{#filter.id} = c.id)
        AND (:#{#filter.countryCode} IS NULL OR :#{#filter.countryCode} = c.countryCode)
        AND (:#{#filter.countryName} IS NULL OR :#{#filter.countryName} = c.countryName)
        AND (:#{#filter.delete} IS NULL OR :#{#filter.delete} = c.delete)
        AND (:#{#filter.beginCreatedAt} IS NULL OR :#{#filter.endCreatedAt} IS NULL OR (c.createdAt >= :#{#filter.beginCreatedAt} AND c.createdAt <= :#{#filter.endCreatedAt}))
        AND (:#{#filter.beginUpdatedAt} IS NULL OR :#{#filter.endUpdatedAt} IS NULL OR (c.createdAt >= :#{#filter.beginUpdatedAt} AND c.createdAt <= :#{#filter.endUpdatedAt}))
        """)
    Page<Country> getCountriesByFilter(@Param("filter") CountryQo filter, Pageable pageable);

    Optional<Country> findCountryByCountryCode(String countryCode);
}
