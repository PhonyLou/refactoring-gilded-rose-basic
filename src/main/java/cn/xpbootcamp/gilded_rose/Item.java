package cn.xpbootcamp.gilded_rose;

public class Item {

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public String getName() {
        return name;
    }

    private final String name;

    private int sellIn;

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    private int quality;

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
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

    private interface QualityOperation {
        int operation(int q);
    }
    private int toNextQuality(int q, QualityOperation qualityOperation) {
        this.setSellIn(this.getSellIn() - 1);

        if (this.getSellIn() < 0) return qualityOperation.operation(q);
        else return q;
    }

    private final QualityOperation updateRegularGoods = q -> {
        if (q > MIN_QUALITY) q = q - 1;
        return q;
    };

    void updateRegularGoodsWhenOneDayPassed() {
        int nextQuality = this.getQuality();
        if (this.getQuality() > MIN_QUALITY) {
            nextQuality = this.getQuality() - 1;
        }

        this.setQuality(toNextQuality(nextQuality, updateRegularGoods));
    }

    private final QualityOperation updateAgedBrie = q -> {
        if (q < MAX_QUALITY) q = q + 1;
        return q;
    };
    void updateAgedBrieWhenOneDayPassed() {
        int nextQuality = this.getQuality();
        if (this.getQuality() < MAX_QUALITY) nextQuality = this.getQuality() + 1;

        this.setQuality(toNextQuality(nextQuality, updateAgedBrie));
    }

    private final QualityOperation updateBackstagePasses = q -> MIN_QUALITY;
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

        this.setQuality(toNextQuality(nextQuality, updateBackstagePasses));
    }
}
