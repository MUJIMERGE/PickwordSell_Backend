package com.smaryn.pws.back.member.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "member_id")
    private Long memberId;
    @Column(name = "member_email", nullable = false, unique = true)
    private String memberEmail;
    @Column(nullable = false)
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "region_large")
    private String regionLarge;
    @Column(name = "region_small")
    private String regionSmall;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegionLarge() {
        return regionLarge;
    }

    public void setRegionLarge(String regionLarge) {
        this.regionLarge = regionLarge;
    }

    public String getRegionSmall() {
        return regionSmall;
    }

    public void setRegionSmall(String regionSmall) {
        this.regionSmall = regionSmall;
    }
}