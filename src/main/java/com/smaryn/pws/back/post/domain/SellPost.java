package com.smaryn.pws.back.post.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class SellPost extends Post {
    private int price;
    private String regionLarge;
    private String regionSmall;
    @Enumerated(EnumType.ORDINAL)
    private SellState sellState;
    private String categoryMain;
    private String categorySub;
}
