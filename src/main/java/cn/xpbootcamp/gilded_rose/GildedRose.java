package cn.xpbootcamp.gilded_rose;

class GildedRose {
    public Item[] getGoods() {
        return goods;
    }

    private final Item[] goods;

    public GildedRose(Item[] goods) {
        this.goods = goods;
    }

    public void update_quality() {
        for (Item goodsItem : this.getGoods()) {
            if (goodsItem.isRegularGoods()) {
                goodsItem.updateRegularGoodsWhenOneDayPassed();
            } else if (goodsItem.isAgedBrie()) {
                goodsItem.updateAgedBrieWhenOneDayPassed();
            } else if (goodsItem.isBackstagePasses()) {
                goodsItem.updateBackstagePassesWhenOneDayPassed();
            }
        }
    }
}
