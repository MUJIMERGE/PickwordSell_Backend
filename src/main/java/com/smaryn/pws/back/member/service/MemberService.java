package com.smaryn.pws.back.member.service;

import com.smaryn.pws.back.member.domain.Member;
import com.smaryn.pws.back.member.repository.MemberRepository;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        member = memberRepository.save(member);
        return member.getMemberId();
    }

    /**
     * 이메일 중복 확인
     */
    public boolean isDuplicateEmail(String memberEmail) {
        return memberRepository.existsByMemberEmail(memberEmail);
    }

    /**
     * 사용자 존재 여부 확인
     */
    public boolean isExistMember(Long memberId) {
        return memberRepository.existsById(memberId);
    }

    /**
     * memberId 로 조회
     */
    public Optional<Member> findMemberById(Long id) {
        return memberRepository.findById(id);
    }

    /**
     * memberId 로 조회
     */
    public Optional<Member> findMemberByEmail(String email) {
        return memberRepository.findByMemberEmail(email);
    }

    /**
     * 회원 정보 변경, 비밀번호 초기화
     */
    public Optional<Member> updateMember(Member member) {
        if (member != null && isExistMember(member.getMemberId())) {
            member = memberRepository.save(member);
            return Optional.of(member);
        } else {
            return Optional.empty();
        }
    }

    /**
     * 회원 탈퇴
     */
    public boolean deleteMember(Long id) {
        Member member = findMemberById(id).orElse(new Member());
        if (member.getMemberEmail() == null) {
            return false;
        } else {
            memberRepository.delete(member);
            return !isDuplicateEmail(member.getMemberEmail());
        }
    }
}
