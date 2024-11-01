package com.gildedrose;

import java.util.Arrays;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (item.quality < 50 && item.isAgedBrie()) {
        item.increaseQuality();
      } else if (item.quality < 50 && item.isBackStage()) {
        increaseQualityOfBackStage(item);
      } else if (item.isRegular() && item.quality > 0) {
        item.decreaseQuality();
      }
    }

    Arrays.stream(items).filter(item -> !item.isSulfuras()).forEach(Item::decreaseSellIn);

    Arrays.stream(items)
        .filter(item -> item.sellIn < 0)
        .forEach(item -> {
          if (item.isAgedBrie() && item.quality < 50) {
            item.increaseQuality();
          } else if (item.isBackStage()) {
            item.loseAllQuality();
          } else if (item.quality > 0 && item.isRegular()) {
            item.decreaseQuality();
          }
        });
  }

  private static void increaseQualityOfBackStage(Item item) {
    item.increaseQuality();
    if (item.sellIn < 11 && item.quality < 50) {
      item.increaseQuality();
    }

    if (item.sellIn < 6 && item.quality < 50) {
      item.increaseQuality();
    }
  }

}