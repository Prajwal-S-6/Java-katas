package com.java.katas;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            reduceQualityIfMoreThanZeroAndNotAgedBrieAndBackstageAndSulfurusItem(i);
            increaseQualityNotMoreThan50ForAgedBrieOrBackstageNotSulfurusItem(i);
            increaseQualityForBackstageItemBasedOnSellIn(i);
            reduceSellInForNonSulfurusItem(i);
        }
    }


    private boolean isBackstage(int i) {
        return items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(int i) {
        return items[i].name.equals("Aged Brie");
    }


    private void increaseQualityForBackstageItemBasedOnSellIn(int i) {
        if (isBackstage(i)) {
            if (items[i].sellIn < 11) {
                increaseQualityNotMoreThan50ForAgedBrieOrBackstageNotSulfurusItem(i);
            }

            if (items[i].sellIn < 6) {
                increaseQualityNotMoreThan50ForAgedBrieOrBackstageNotSulfurusItem(i);
            }
        }
    }


    private void increaseQualityNotMoreThan50ForAgedBrieOrBackstageNotSulfurusItem(int i) {
        if (items[i].quality < 50 && (isAgedBrie(i) || isBackstage(i)) && !isSulfurus(i)) {
            items[i].quality = items[i].quality + 1;
        }
    }

    private void reduceQualityIfMoreThanZeroAndNotAgedBrieAndBackstageAndSulfurusItem(int i) {
        if (items[i].quality > 0 && !isAgedBrie(i) && !isBackstage(i) && !isSulfurus(i)) {
            items[i].quality = items[i].quality - 1;
        }
    }

    private boolean isSulfurus(int i) {
        return items[i].name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void reduceSellInForNonSulfurusItem(int i) {
        if (!isSulfurus(i)) {
            items[i].sellIn = items[i].sellIn - 1;
            handleWhenSellInWhenLessThanZero(i);
        }
    }
    private void handleWhenSellInWhenLessThanZero(int i) {
        if (items[i].sellIn < 0) {
            increaseQualityNotMoreThan50ForAgedBrieOrBackstageNotSulfurusItem(i);
            reduceQualityToZeroForBackStageItem(i);
        }
        reduceQualityIfMoreThanZeroAndNotAgedBrieAndBackstageAndSulfurusItem(i);
    }

    private void reduceQualityToZeroForBackStageItem(int i) {
        if(isBackstage(i)) {
            items[i].quality = items[i].quality - items[i].quality;
        }
    }
}