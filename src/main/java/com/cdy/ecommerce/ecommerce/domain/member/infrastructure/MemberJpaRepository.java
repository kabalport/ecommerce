package com.cdy.ecommerce.ecommerce.domain.member.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, String> {}

