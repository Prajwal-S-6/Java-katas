package com.java.katas;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            reduceQualityByOneForNonAgedBrieBackstageSulfurusNotLessThanZero(i);
            increaseQualityNotMoreThan50ForAgedBrieOrBackstage(i);
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
                increaseQualityNotMoreThan50ForAgedBrieOrBackstage(i);
            }

            if (items[i].sellIn < 6) {
                increaseQualityNotMoreThan50ForAgedBrieOrBackstage(i);
            }
        }
    }


    private void increaseQualityNotMoreThan50ForAgedBrieOrBackstage(int i) {
        if ((isAgedBrie(i) || isBackstage(i)) && items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }

    private void reduceQualityByOneForNonAgedBrieBackstageSulfurusNotLessThanZero(int i) {
        if (items[i].quality > 0 && !isSulfurus(i) && !isAgedBrie(i) && !isBackstage(i)) {
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
            increaseQualityNotMoreThan50ForAgedBrieOrBackstage(i);
            reduceQualityToZeroForBackStageItem(i);
        }
        reduceQualityByOneForNonAgedBrieBackstageSulfurusNotLessThanZero(i);
    }

    private void reduceQualityToZeroForBackStageItem(int i) {
        if(isBackstage(i)) {
            items[i].quality = items[i].quality - items[i].quality;
        }
    }
}