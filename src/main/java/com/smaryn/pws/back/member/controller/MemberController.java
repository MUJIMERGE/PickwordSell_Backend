package com.smaryn.pws.back.member.controller;

import com.smaryn.pws.back.member.domain.Member;
import com.smaryn.pws.back.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원 가입
     * @param requestMember
     * @return memberId
     */
    @PostMapping()
    @ResponseBody
    public HashMap<String, Object> createMember(@RequestBody Member requestMember) {
        HashMap<String, Object> hashMap = new HashMap<>();
        long memberId = memberService.join(requestMember);
        Date date = new Date(System.currentTimeMillis());

        if (memberId != -1) {
            hashMap.put("timestamp", sdf.format(date));
            hashMap.put("status", 201);
            hashMap.put("memberId", memberId);
        } else {
            hashMap.put("timestamp", sdf.format(date));
            hashMap.put("status", 400);
        }

        return hashMap;
    }

    /**
     * 회원 조회
     * @param id
     * @return member
     */
    @GetMapping("/{id}")
    @ResponseBody
    public HashMap<String, Object> findMember(@PathVariable Long id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Date date = new Date(System.currentTimeMillis());

        try {
            Member member = memberService.findMemberById(id).orElseThrow();
            hashMap.put("timestamp", sdf.format(date));
            hashMap.put("status", 201);
            hashMap.put("member", member);
        } catch (NoSuchElementException e) {
            hashMap.put("timestamp", sdf.format(date));
            hashMap.put("status", 400);
        }

        return hashMap;
    }

    /**
     * 회원 탈퇴
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public HashMap<String, Object> deleteMember(@PathVariable Long id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        boolean isDeleteSuccess = memberService.deleteMember(id);
        Date date = new Date(System.currentTimeMillis());

        if (isDeleteSuccess ) {
            hashMap.put("timestamp", sdf.format(date));
            hashMap.put("status", 201);
            hashMap.put("memberId", id);
        } else {
            hashMap.put("timestamp", sdf.format(date));
            hashMap.put("status", 400);
        }

        return hashMap;
    }

    /**
     * 회원 정보 변경
     * @param requestMember
     * @param id
     * @return memberId
     */
    @PutMapping("/{id}")
    @ResponseBody
    public HashMap<String, Object> updateMember(@RequestBody Member requestMember, @PathVariable Long id) {
        requestMember.setMemberId(id);
        HashMap<String, Object> hashMap = new HashMap<>();
        Date date = new Date(System.currentTimeMillis());

        try {
            Member updateMember = memberService.updateMember(requestMember).orElseThrow();
            hashMap.put("timestamp", sdf.format(date));
            hashMap.put("status", 201);
            hashMap.put("memberId", updateMember.getMemberId());
        } catch (NoSuchElementException e) {
            hashMap.put("timestamp", sdf.format(date));
            hashMap.put("status", 400);
        }

        return hashMap;
    }

    /**
     * 회원 로그인
     * @param requestMember
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public HashMap<String, Object> updateMember(@RequestBody Member requestMember) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Date date = new Date(System.currentTimeMillis());

        try {
            Member member = memberService.findMemberByEmail(requestMember.getMemberEmail()).orElseThrow();
            if (member.getPassword().equals(requestMember.getPassword())) {
                hashMap.put("timestamp", sdf.format(date));
                hashMap.put("status", 201);
                hashMap.put("member", member);
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            hashMap.put("timestamp", sdf.format(date));
            hashMap.put("status", 400);
        }

        return hashMap;
    }

    /**
     * 회원 비밀번호 초기화
     * @param requestMember
     * @param id
     * @return
     */
    @PatchMapping("/password/{id}")
    @ResponseBody
    public HashMap<String, Object> passwordReset(@RequestBody Member requestMember, @PathVariable Long id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Date date = new Date(System.currentTimeMillis());

        try {
            Member member = memberService.findMemberByEmail(requestMember.getMemberEmail()).orElseThrow();
            if (member.getPhoneNumber().equals(requestMember.getPhoneNumber())) {
                member.setPassword("initPassword"); // 임시 코드
                member = memberService.updateMember(member).orElseThrow();

                hashMap.put("timestamp", sdf.format(date));
                hashMap.put("status", 201);
                hashMap.put("password", member.getPassword());
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            hashMap.put("timestamp", sdf.format(date));
            hashMap.put("status", 400);
        }

        return hashMap;
    }
}
