package cn.xpbootcamp.gilded_rose;

import static cn.xpbootcamp.gilded_rose.Item.MAX_QUALITY;
import static cn.xpbootcamp.gilded_rose.Item.MIN_QUALITY;

class GildedRose {
    Item[] goods;

    public GildedRose(Item[] goods) {
        this.goods = goods;
    }

    public void update_quality() {
        for (Item good : goods) {
            if (good.isRegularGoods()) {
                good.updateRegularGoodsWhenOneDayPassed();
            } else if (good.isAgedBrie()) {
                good.updateAgedBrieWhenOneDayPassed();
            } else if (good.isBackstagePasses()) {
                good.updateBackstagePassesWhenOneDayPassed();
            }
        }
    }
}
