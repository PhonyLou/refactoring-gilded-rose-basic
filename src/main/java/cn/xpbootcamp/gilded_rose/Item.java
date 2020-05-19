package cn.xpbootcamp.gilded_rose;

public class Item {

    public String getName() {
        return name;
    }

    public String name;

    public int sellIn;

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int quality;

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
}
