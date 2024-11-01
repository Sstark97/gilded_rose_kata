package com.gildedrose;

import java.util.Arrays;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQualityOld() {
    Arrays.stream(items).forEach(Item::updateQuality);

    Arrays.stream(items)
        .filter(item -> !(item instanceof Sulfuras))
        .forEach(Item::decreaseSellIn);

    Arrays.stream(items)
        .filter(Item::finishSellIn)
        .forEach(Item::updateQualityIfFinishSellIn);
  }

}