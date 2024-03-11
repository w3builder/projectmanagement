package com.project.management.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.management.domain.models.Member;
import com.project.management.domain.models.MemberId;

public interface MemberRepository extends JpaRepository<Member, MemberId> {

}
