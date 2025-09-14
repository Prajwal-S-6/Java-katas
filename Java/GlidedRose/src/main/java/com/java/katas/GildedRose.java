package com.java.katas;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            boolean isNotBackstageItem = !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean isNotAgedBrieItem = !items[i].name.equals("Aged Brie");
            if (isNotAgedBrieItem
                    && isNotBackstageItem) {
                reduceQualityForNonSulfurusItem(i);
            } else {
                increaseQualityNotMoreThan50(i);
                increaseQualityForBackstageItemBasedOnSellIn(i);
            }

            reduceSellInForNonSulfurusItem(i);

            if (items[i].sellIn < 0) {
                if (isNotAgedBrieItem) {
                    if (isNotBackstageItem) {
                        reduceQualityForNonSulfurusItem(i);
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    increaseQualityNotMoreThan50(i);
                }
            } else {
                if (items[i].name.equals("Conjured Mana Cake")) {
                    reduceQualityForNonSulfurusItem(i);
                }
            }
        }
    }

    private void increaseQualityForBackstageItemBasedOnSellIn(int i) {
        if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items[i].sellIn < 11) {
                increaseQualityNotMoreThan50(i);
            }

            if (items[i].sellIn < 6) {
                increaseQualityNotMoreThan50(i);
            }
        }
    }


    private void increaseQualityNotMoreThan50(int i) {
        if (items[i].quality < 50) {
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