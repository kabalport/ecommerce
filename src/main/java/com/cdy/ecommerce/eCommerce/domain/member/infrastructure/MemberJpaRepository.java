package com.cdy.ecommerce.eCommerce.domain.member.infrastructure;

import com.cdy.ecommerce.eCommerce.domain.member.Models.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, String> {

    @EntityGraph(attributePaths = {"memberRoleList"})
    @Query("select m from Member m where m.userId = :userId")
    Member getWithRoles(@Param("userId") Long userId);

    @Query("select m from Member m where m.memberId = :memberId")
    Optional<Member> selectOne(Long memberId);
}
