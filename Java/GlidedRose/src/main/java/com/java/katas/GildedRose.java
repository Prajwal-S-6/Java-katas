package com.java.katas;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            boolean isNotBackstageItem = !isBackstage(i);
            boolean isNotAgedBrieItem = !isAgedBrie(i);
            if (isNotAgedBrieItem
                    && isNotBackstageItem) {
                reduceQualityForNonSulfurusItem(i);
            } else {
                increaseQualityNotMoreThan50ForAgedBrieOrBackstage(i);
                increaseQualityForBackstageItemBasedOnSellIn(i);
            }

            reduceSellInForNonSulfurusItem(i);

            if (items[i].sellIn < 0) {
                increaseQualityNotMoreThan50ForAgedBrieOrBackstage(i);

                if (isNotAgedBrieItem) {
                    if (isNotBackstageItem) {
                        reduceQualityForNonSulfurusItem(i);
                    } else {
                        reduceQualityToZeroForBackStageItem(i);
                    }

                }
            } else {
                if (items[i].name.equals("Conjured Mana Cake")) {
                    reduceQualityForNonSulfurusItem(i);
                }
            }
        }
    }

    private boolean isBackstage(int i) {
        return items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(int i) {
        return items[i].name.equals("Aged Brie");
    }

    private void reduceQualityToZeroForBackStageItem(int i) {
        items[i].quality = items[i].quality - items[i].quality;
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

    private void reduceQualityForNonSulfurusItem(int i) {
        if (items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].quality = items[i].quality - 1;
        }
    }

    private void reduceSellInForNonSulfurusItem(int i) {
        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].sellIn = items[i].sellIn - 1;
        }
    }
}