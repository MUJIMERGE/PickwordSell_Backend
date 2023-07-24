package com.smaryn.pws.back.post.repository;

import com.smaryn.pws.back.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPostRepository extends JpaRepository<Post, Long> {
    List<Post> findByMemberEmail(Long memberEmail);
}
