package cn.xpbootcamp.gilded_rose;

class GildedRose {
    Item[] goods;

    public GildedRose(Item[] goods) {
        this.goods = goods;
    }

    public void update_quality() {
        for (Item goodsItem : goods) {
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
