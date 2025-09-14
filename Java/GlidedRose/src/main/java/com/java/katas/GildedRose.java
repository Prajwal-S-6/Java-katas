package com.java.katas;

class GildedRose {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if(isSulfurus(item)) continue;  //do nothing

            updateItemQuality(item);
            reduceSellIn(item);
            handleExpiredItem(item);
        }
    }


    private static void updateItemQuality(Item item) {
        if(isAgedBrie(item)) {
            increaseQualityIfNotMaximum(item);
        } else if (isBackStageProcess(item)) {
            increaseQualityIfNotMaximum(item);
            handleQualityForBackstageProcessBasedOnSellIn(item);
        } else {
            reduceQualityIfNotMinimum(item);
        }
    }

    private static void handleQualityForBackstageProcessBasedOnSellIn(Item item) {
        if (item.sellIn < 11) {
            increaseQualityIfNotMaximum(item);
        }

        if (item.sellIn < 6) {
            increaseQualityIfNotMaximum(item);
        }
    }

    private static void reduceSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private static void handleExpiredItem(Item item) {
        if (item.sellIn < 0) {
            if(isAgedBrie(item)) {
                increaseQualityIfNotMaximum(item);
            } else {
                if(isBackStageProcess(item)) {
                    item.quality = MIN_QUALITY;
                } else {
                    reduceQualityIfNotMinimum(item);
                }
            }
        }
    }

    private static void reduceQualityIfNotMinimum(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    private static void increaseQualityIfNotMaximum(Item item) {
        if (item.quality < MAX_QUALITY)
        {
            item.quality = item.quality + 1;
        }
    }

    private static boolean isSulfurus(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private static boolean isBackStageProcess(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}
