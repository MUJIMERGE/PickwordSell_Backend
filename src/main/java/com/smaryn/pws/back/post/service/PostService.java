package com.smaryn.pws.back.post.service;

import com.smaryn.pws.back.post.domain.Post;
import com.smaryn.pws.back.post.domain.SellPost;
import com.smaryn.pws.back.post.repository.JpaPostRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class PostService {
    private final JpaPostRepository postRepository;

    public PostService(JpaPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * 거래글 작성
     */
    public Long addSellPost(SellPost sellPost) {
        sellPost = (SellPost) postRepository.save(sellPost);
        return sellPost.getPostId();
    }

//    /**
//     * 글 목록 조회 -> 페이징 기능
//     */
//    public List<Post> findPostList() {
//        return postRepository.
//    }

    /**
     * 글 조회
     */
    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }

    /**
     * 거래글 존재 여부 확인
     */
    public boolean isExistPost(Long id) {
        return postRepository.existsById(id);
    }

    /**
     * 거래글 수정
     */
    public Optional<Post> updatePost(Post post) {
        if (post != null && isExistPost(post.getPostId())) {
            post = postRepository.save(post);
            return Optional.of(post);
        } else {
            return Optional.empty();
        }
    }

    /**
     * 거래글 상태 변경
     */

    /**
     * 글 삭제
     */
    public boolean deletePost(Long id) {
        Post post = findPostById(id).orElse(new Post());
        postRepository.delete(post);
        return isExistPost(post.getPostId());
    }
}
