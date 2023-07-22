package com.smaryn.pws.back.member.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(nullable = false)
    private String memberEmail;
    @Column(nullable = false)
    private String password;
    private String phoneNumber;
    private String regionLarge;
    private String regionSmall;
}