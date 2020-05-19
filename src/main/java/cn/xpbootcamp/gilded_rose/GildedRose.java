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
                if (good.getQuality() < MAX_QUALITY) {
                    good.setQuality(good.getQuality() + 1);
                }
                if (good.getSellIn() < 11 && good.getQuality() < MAX_QUALITY) {
                    good.setQuality(good.getQuality() + 1);
                }

                if (good.getSellIn() < 6 && good.getQuality() < MAX_QUALITY) {
                    good.setQuality(good.getQuality() + 1);
                }
            }

            if (!good.isSulfuras() && !good.isRegularGoods() && !good.isAgedBrie()) {
                good.setSellIn(good.getSellIn() - 1);
            }

            if (good.getSellIn() < 0) {


                if (good.isBackstagePasses()) {
                    good.setQuality(MIN_QUALITY);
                }
            }
        }
    }
}
