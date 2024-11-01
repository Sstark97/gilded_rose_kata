package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
      for (Item item : items) {
        if (item.isAgedBrie() || item.isBackStage()) {
          increaseQualityOf(item);
        } else {
          if (item.quality > 0 && !item.isSulfuras()) {
            item.decreaseQuality();
          }
        }

        if (!item.isSulfuras()) {
          item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
          if (item.isAgedBrie()) {
            if (item.quality < 50) {
              item.increaseQuality();
            }
          } else {
            if (item.isBackStage()) {
              item.quality = 0;
            } else {
              if (item.quality > 0 && !item.isSulfuras()) {
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
      if (item.isBackStage()) {
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

}