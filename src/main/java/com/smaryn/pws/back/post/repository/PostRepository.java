package com.smaryn.pws.back.post.repository;

import com.smaryn.pws.back.post.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(Long id);
    List<Post> findAll();
    List<Post> findByMemberEmail(Long memberEmail);
    void delete(Post post);
}
