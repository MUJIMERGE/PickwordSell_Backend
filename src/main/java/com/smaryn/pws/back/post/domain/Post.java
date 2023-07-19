package com.smaryn.pws.back.post.domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private String[] img;
    @Column(nullable = false)
    private String memberEmail;
}
