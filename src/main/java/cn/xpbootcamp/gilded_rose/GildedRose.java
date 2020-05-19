package cn.xpbootcamp.gilded_rose;

class GildedRose {
    Item[] goods;

    public GildedRose(Item[] goods) {
        this.goods = goods;
    }

    public void update_quality() {
        for (int i = 0; i < goods.length; i++) {
            if (!goods[i].isAgedBrie()
                    && !goods[i].isBackstagePasses()) {
                if (goods[i].getQuality() > 0) {
                    if (!goods[i].isSulfuras()) {
                        goods[i].setQuality(goods[i].getQuality() - 1);
                    }
                }
            } else {
                if (goods[i].getQuality() < 50) {
                    goods[i].setQuality(goods[i].getQuality() + 1);

                    if (goods[i].isBackstagePasses()) {
                        if (goods[i].getSellIn() < 11) {
                            if (goods[i].getQuality() < 50) {
                                goods[i].setQuality(goods[i].getQuality() + 1);
                            }
                        }

                        if (goods[i].getSellIn() < 6) {
                            if (goods[i].getQuality() < 50) {
                                goods[i].setQuality(goods[i].getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!goods[i].isSulfuras()) {
                goods[i].setSellIn(goods[i].getSellIn() - 1);
            }

            if (goods[i].getSellIn() < 0) {
                if (!goods[i].isAgedBrie()) {
                    if (!goods[i].isBackstagePasses()) {
                        if (goods[i].getQuality() > 0) {
                            if (!goods[i].isSulfuras()) {
                                goods[i].setQuality(goods[i].getQuality() - 1);
                            }
                        }
                    } else {
                        goods[i].setQuality(0);
                    }
                } else {
                    if (goods[i].getQuality() < 50) {
                        goods[i].setQuality(goods[i].getQuality() + 1);
                    }
                }
            }
        }
    }
}
