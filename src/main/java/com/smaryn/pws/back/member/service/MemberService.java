package com.smaryn.pws.back.member.service;

import com.smaryn.pws.back.member.repository.MemberRepository;
import jakarta.transaction.Transactional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
