package com.smaryn.pws.back.member.repository;

import com.smaryn.pws.back.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByEmail(String memberEmail);
    List<Member> findAll();
    void delete(Member member);
}
