package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
      for (Item item : items) {
        if (isAgedBrie(item) || isBackStage(item)) {
          increaseQualityOf(item);
        } else {
          if (item.quality > 0 && !isSulfuras(item)) {
            item.decreaseQuality();
          }
        }

        if (!isSulfuras(item)) {
          item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
          if (isAgedBrie(item)) {
            if (item.quality < 50) {
              item.increaseQuality();
            }
          } else {
            if (isBackStage(item)) {
              item.quality = 0;
            } else {
              if (item.quality > 0 && !isSulfuras(item)) {
                item.decreaseQuality();
              }
            }
          }
        }
      }
    }

  private static void increaseQualityOf(Item item) {
    if (item.quality < 50) {
      item.increaseQuality();
      if (isBackStage(item)) {
        increaseQualityOfBackStage(item);
      }
    }
  }

  private static void increaseQualityOfBackStage(Item item) {
    if (item.sellIn < 11 && item.quality < 50) {
      item.increaseQuality();
    }

    if (item.sellIn < 6 && item.quality < 50) {
      item.increaseQuality();
    }
  }

  private static boolean isSulfuras(Item item) {
    return item.name.equals("Sulfuras, Hand of Ragnaros");
  }

  private static boolean isBackStage(Item item) {
    return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  private static boolean isAgedBrie(Item item) {
    return item.name.equals("Aged Brie");
  }
}