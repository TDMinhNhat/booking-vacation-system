package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.User;
import io.github.tdminhnhat.service.model.qo.UserQo;
import io.github.tdminhnhat.service.model.vo.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
        select u from User u
        where (:#{#filter.id} is null or u.id = :#{#filter.id})
        and (:#{#filter.firstName} is null or u.firstName = :#{#filter.firstName})
        and (:#{#filter.lastName} is null or u.lastName = :#{#filter.lastName})
        and (:#{#filter.sex} is null or u.sex = :#{#filter.sex})
        and (:#{#filter.birthDate} is null or u.birthDate = :#{#filter.birthDate})
        and (:#{#filter.phoneNumber} is null or u.phoneNumber = :#{#filter.phoneNumber})
        and (:#{#filter.username} is null or u.username = :#{#filter.username})
        and (:#{#filter.email} is null or u.email = :#{#filter.email})
        and (:#{#filter.role} is null or u.role = :#{#filter.role})
        and (:#{#filter.blocking} is null or u.blocking = :#{#filter.blocking})
        and (:#{#filter.delete} is null or u.delete = :#{#filter.delete})
        and (:#{#filter.beginCreatedAt} is null or :#{#filter.end} or u.delete = :#{#filter.delete})
        """)
    Page<UserVo> getAllUsersByFilter(@Param("filter") UserQo filter, Pageable pageable);
}
