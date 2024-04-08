package com.cdy.ecommerce.ecommerce.domain.member.business.repository;

import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import com.cdy.ecommerce.ecommerce.domain.member.infrastructure.MemberJpaRepository;
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

    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> selectUserId(String userId);
}
