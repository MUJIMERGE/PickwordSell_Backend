package com.smaryn.pws.back.post.domain;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("sell")
public class SellPost extends Post {
    private int price;
    @Column(name = "region_large")
    private String regionLarge;
    @Column(name = "region_small")
    private String regionSmall;
    @Column(name = "sell_state")
    @Enumerated(EnumType.STRING)
    private SellState sellState;
    @Column(name = "category_main")
    private String categoryMain;
    @Column(name = "category_sub")
    private String categorySub;
}
