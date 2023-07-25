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
     * @param requestMember
     * @return
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

//    @GetMapping()
//    public List<Member> getAllMember() {
//
//    }
//
//    @GetMapping("/{id}")
//    public HashMap<String, Object> getMember(@PathVariable Long id) {
//
//    }
//
//    @DeleteMapping("/{id}")
//    public HashMap<String, Object> deleteMember(@PathVariable Long id) {
//
//    }
}
