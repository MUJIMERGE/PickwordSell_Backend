package com.smaryn.pws.back.post.repository;

import com.smaryn.pws.back.post.domain.SellPost;

import java.util.List;

public interface SellPostRepository extends PostRepository {
    List<SellPost> findByFilter(SellPost sellPost, boolean isCheckSellState);
}
