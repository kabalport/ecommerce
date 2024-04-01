package com.cdy.ecommerce.eCommerce.domain.member.business.Repositories;

import com.cdy.ecommerce.eCommerce.domain.member.business.Models.Member;
import com.cdy.ecommerce.eCommerce.domain.member.infrastructure.MemberJpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberReaderRepository extends MemberJpaRepository {
    @EntityGraph(attributePaths = {"memberRoleList"})
    @Query("select m from Member m where m.userId = :userId")
    Member getWithRoles(@Param("userId") Long userId);

    @Query("select m from Member m where m.memberId = :memberId")
    Optional<Member> selectOne(Long memberId);
}
