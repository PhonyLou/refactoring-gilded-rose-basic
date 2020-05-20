package cn.xpbootcamp.gilded_rose;

public class Item {

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private final String name;
    private int sellIn;
    QualityOperation updateAgedBrie = (int q) -> {
        if (this.getSellIn() < 0 && q > MIN_QUALITY)
            q = q - 1;
        return q;
    };
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    boolean isAgedBrie() {
        return "Aged Brie".equals(this.getName());
    }

    boolean isBackstagePasses() {
        return "Backstage passes to a TAFKAL80ETC concert".equals(this.getName());
    }

    boolean isSulfuras() {
        return "Sulfuras, Hand of Ragnaros".equals(this.getName());
    }

    boolean isRegularGoods() {
        return !isSulfuras() && !isBackstagePasses() && !isAgedBrie();
    }

    private int nextQuality(int q, QualityOperation qualityOperation) {
        return qualityOperation.operation(q);
    }

    void updateRegularGoodsWhenOneDayPassed() {
        int nextQuality = this.getQuality();
        if (this.getQuality() > MIN_QUALITY) {
            nextQuality = this.getQuality() - 1;
        }
        this.setSellIn(this.getSellIn() - 1);
        this.setQuality(nextQuality(nextQuality, updateAgedBrie));
    }

    void updateAgedBrieWhenOneDayPassed() {
        int nextQuality = this.getQuality();
        if (this.getQuality() < MAX_QUALITY) {
            nextQuality = this.getQuality() + 1;
        }

        this.setSellIn(this.getSellIn() - 1);

        if (this.getSellIn() < 0) {
            if (nextQuality < MAX_QUALITY) {
                nextQuality = nextQuality + 1;
            }
        }

        this.setQuality(nextQuality);
    }

    void updateBackstagePassesWhenOneDayPassed() {
        int nextQuality = this.getQuality();

        if (this.getQuality() < MAX_QUALITY) {
            nextQuality = this.getQuality() + 1;
        }
        if (this.getSellIn() < 11 && nextQuality < MAX_QUALITY) {
            nextQuality = nextQuality + 1;
        }
        if (this.getSellIn() < 6 && nextQuality < MAX_QUALITY) {
            nextQuality = nextQuality + 1;
        }

        this.setSellIn(this.getSellIn() - 1);

        if (this.getSellIn() < 0) {
            nextQuality = MIN_QUALITY;
        }

        this.setQuality(nextQuality);
    }

    interface QualityOperation {
        int operation(int q);
    }
}
