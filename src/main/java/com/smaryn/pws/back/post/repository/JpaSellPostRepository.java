package com.smaryn.pws.back.post.repository;

import com.smaryn.pws.back.post.domain.SellPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaSellPostRepository extends JpaRepository<SellPost, Long> {
    // @Query("select sp from SellPost sp where sp.") 쿼리는 나중에 정의
    // List<SellPost> findByFilter(SellPost sellPost, boolean isCheckSellState, int minPrice, int maxPrice);
}
