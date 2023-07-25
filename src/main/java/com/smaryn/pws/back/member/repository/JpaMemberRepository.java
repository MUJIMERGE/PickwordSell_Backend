package com.smaryn.pws.back.member.repository;

import com.smaryn.pws.back.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    Optional<Member> findByMemberEmail(String memberEmail);
    boolean existsByMemberEmail(String memberEmail);
}
