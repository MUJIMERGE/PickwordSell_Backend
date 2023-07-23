package com.smaryn.pws.back.member.repository;

import com.smaryn.pws.back.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByEmail(String memberEmail);
}
