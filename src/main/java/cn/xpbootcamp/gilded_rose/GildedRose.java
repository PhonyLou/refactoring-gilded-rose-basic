package cn.xpbootcamp.gilded_rose;

class GildedRose {
    Item[] goods;

    public GildedRose(Item[] goods) {
        this.goods = goods;
    }

    public void update_quality() {
        for (int i = 0; i < goods.length; i++) {
            if (!goods[i].getName().equals("Aged Brie")
                    && !goods[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (goods[i].quality > 0) {
                    if (!goods[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                        goods[i].quality = goods[i].quality - 1;
                    }
                }
            } else {
                if (goods[i].quality < 50) {
                    goods[i].quality = goods[i].quality + 1;

                    if (goods[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (goods[i].sell_in < 11) {
                            if (goods[i].quality < 50) {
                                goods[i].quality = goods[i].quality + 1;
                            }
                        }

                        if (goods[i].sell_in < 6) {
                            if (goods[i].quality < 50) {
                                goods[i].quality = goods[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!goods[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                goods[i].sell_in = goods[i].sell_in - 1;
            }

            if (goods[i].sell_in < 0) {
                if (!goods[i].getName().equals("Aged Brie")) {
                    if (!goods[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (goods[i].quality > 0) {
                            if (!goods[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                                goods[i].quality = goods[i].quality - 1;
                            }
                        }
                    } else {
                        goods[i].quality = 0;
                    }
                } else {
                    if (goods[i].quality < 50) {
                        goods[i].quality = goods[i].quality + 1;
                    }
                }
            }
        }
    }
}
