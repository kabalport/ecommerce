package com.cdy.ecommerce.eCommerce.domain.member.infrastructure;

import com.cdy.ecommerce.eCommerce.domain.member.business.Models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, String> {}

