package com.smaryn.pws.back.member.repository;

import com.smaryn.pws.back.member.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepositoryImpl implements MemberRepository {
    private final EntityManager em;

    public JpaMemberRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByEmail(String memberEmail) {
        List<Member> result = em.createQuery("select m from Member m where m.memberEmail = :memberEmail", Member.class)
                .setParameter("memberEmail", memberEmail)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public void delete(Member member) {
        em.remove(member);
    }
}
