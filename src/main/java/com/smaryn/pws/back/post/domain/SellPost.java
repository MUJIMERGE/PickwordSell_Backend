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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRegionLarge() {
        return regionLarge;
    }

    public void setRegionLarge(String regionLarge) {
        this.regionLarge = regionLarge;
    }

    public String getRegionSmall() {
        return regionSmall;
    }

    public void setRegionSmall(String regionSmall) {
        this.regionSmall = regionSmall;
    }

    public SellState getSellState() {
        return sellState;
    }

    public void setSellState(SellState sellState) {
        this.sellState = sellState;
    }

    public String getCategoryMain() {
        return categoryMain;
    }

    public void setCategoryMain(String categoryMain) {
        this.categoryMain = categoryMain;
    }

    public String getCategorySub() {
        return categorySub;
    }

    public void setCategorySub(String categorySub) {
        this.categorySub = categorySub;
    }
}
