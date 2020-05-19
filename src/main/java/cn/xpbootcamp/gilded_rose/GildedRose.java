package cn.xpbootcamp.gilded_rose;

class GildedRose {
    Item[] goods;

    public GildedRose(Item[] goods) {
        this.goods = goods;
    }

    public void update_quality() {
        for (Item good : goods) {
            if (!good.isAgedBrie()
                    && !good.isBackstagePasses()) {
                if (good.getQuality() > 0) {
                    if (!good.isSulfuras()) {
                        good.setQuality(good.getQuality() - 1);
                    }
                }
            } else {
                if (good.getQuality() < 50) {
                    good.setQuality(good.getQuality() + 1);

                    if (good.isBackstagePasses()) {
                        if (good.getSellIn() < 11) {
                            if (good.getQuality() < 50) {
                                good.setQuality(good.getQuality() + 1);
                            }
                        }

                        if (good.getSellIn() < 6) {
                            if (good.getQuality() < 50) {
                                good.setQuality(good.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!good.isSulfuras()) {
                good.setSellIn(good.getSellIn() - 1);
            }

            if (good.getSellIn() < 0) {
                if (good.isAgedBrie()) {
                    if (good.getQuality() < 50) {
                        good.setQuality(good.getQuality() + 1);
                    }
                    continue;
                }
                if (!good.isAgedBrie()) {
                    if (!good.isBackstagePasses()) {
                        if (good.getQuality() > 0) {
                            if (!good.isSulfuras()) {
                                good.setQuality(good.getQuality() - 1);
                            }
                        }
                    } else {
                        good.setQuality(0);
                    }
                }
            }
        }
    }
}
