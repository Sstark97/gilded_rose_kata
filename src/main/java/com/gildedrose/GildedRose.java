package com.gildedrose;

import java.util.Arrays;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (item.isQualityBellowTheMinimum() && item.isAgedBrie()) {
        item.increaseQuality();
      } else if (item.isQualityBellowTheMinimum() && item.isBackStage()) {
        item.increaseQualityOfBackStage();
      } else if (item.isRegular() && item.notLoseAllQuality()) {
        item.decreaseQuality();
      }
    }

    Arrays.stream(items).filter(item -> !item.isSulfuras()).forEach(Item::decreaseSellIn);

    Arrays.stream(items)
        .filter(Item::finishSellIn)
        .forEach(item -> {
          if (item.isAgedBrie() && item.isQualityBellowTheMinimum()) {
            item.increaseQuality();
          } else if (item.isBackStage()) {
            item.loseAllQuality();
          } else if (item.notLoseAllQuality() && item.isRegular()) {
            item.decreaseQuality();
          }
        });
  }

}