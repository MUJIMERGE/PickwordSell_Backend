package com.smaryn.pws.back.post.domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="postType")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "post_id")
    private Long postId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private String[] img;
    @Column(nullable = false, name = "member_email")
    private String memberEmail;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getImg() {
        return img;
    }

    public void setImg(String[] img) {
        this.img = img;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
}
