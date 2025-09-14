package com.java.katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void shouldReduceQualityTwiceWhenSellInIsLessThanZero() {
        Item[] items = new Item[] { new Item("foo", 0, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(38);
    }

    @Test
    void shouldNotReduceQualityOfItemToNegative() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0),
                new Item("Conjured Mana Cake", 0, 0),

        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isNotNegative();
        assertThat(app.items[1].quality).isNotNegative();
        assertThat(app.items[2].quality).isNotNegative();
        assertThat(app.items[3].quality).isNotNegative();
    }

    @Test
    void shouldNotIncreaseQualityBeyond50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
                };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isLessThanOrEqualTo(50);
        assertThat(app.items[1].quality).isLessThanOrEqualTo(50);
    }

    @Test
    void shouldNotDecreaseSellInAndQualityForSulfurasItem() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(80);
        assertThat(app.items[0].sellIn).isEqualTo(2);
    }

    @Test
    void shouldNotDecreaseSellInAndQualityForSulfurasItemWhenSellInLessThanZero() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(80);
        assertThat(app.items[0].sellIn).isEqualTo(-1);
    }

    @Test
    void shouldIncreaseQualityByTwoForAgedBrieItemWhenSellInGoesLessThanZero() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 46),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(48);

    }

    @Test
    void shouldIncreaseQualityByOneForAgedBrieItemWhenSellInMoreThanZero() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 1, 46),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(47);
    }

    @Test
    void shouldIncreaseQualityByTwoWhenSellInIsTenDaysAreLess() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(42);
    }

    @Test
    void shouldIncreaseQualityByTwoWhenSellInIsTenDaysAreLessButNotMoreThan50() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void shouldIncreaseQualityForBackstageByThreeWhenSellInIsFiveDaysAreLess() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(43);
    }

    @Test
    void shouldIncreaseQualityForBackstageByThreeWhenSellInIsFiveDaysAreLessButNotMoreThan50() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void shouldIncreaseQualityForBackstageByOneWhenSellInIsMoreThanTenDays() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(41);
    }

    @Test
    void shouldReduceQualityForBackstageToZeroWhenSellInIsLessThanZeroDays() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void shouldReduceQualityByTwoForConjuredItems() {
        Item[] items = new Item[] {
                new Item("Conjured Mana Cake", 3, 6),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(5);
    }

    @Test
    void shouldReduceQualityByTwoForConjuredItemsWhenQualityIsMoreThanZero() {
        Item[] items = new Item[] {
                new Item("Conjured Mana Cake", 3, 1),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }



}
