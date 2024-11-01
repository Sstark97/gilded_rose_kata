package com.gildedrose.item.types;

import com.gildedrose.UpdatableItem;

public class BackstagePasses extends Item implements UpdatableItem {
  private static final int MAXIMUM_QUALITY = 50;

  public BackstagePasses(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    updateQuality();

    decreaseSellIn();

    updateQualityIfFinishSellIn();
  }

  private void updateQuality() {
    if (isQualityBellowTheMaximum()) {
      increaseQuality();
      increaseQualityIfElevenDaysOfSellInRemain();
      increaseQualityIfSixDaysOfSellInRemain();
    }
  }

  private void increaseQualityIfSixDaysOfSellInRemain() {
    if (isQualityBellowTheMaximum() && sellIn < 6) {
      increaseQuality();
    }
  }

  private void increaseQualityIfElevenDaysOfSellInRemain() {
    if (isQualityBellowTheMaximum() && sellIn < 11) {
      increaseQuality();
    }
  }

  private void updateQualityIfFinishSellIn() {
    if (isSellInFinish()) {
      quality = 0;
    }
  }

  private boolean isSellInFinish() {
    return sellIn < 0;
  }

  private boolean isQualityBellowTheMaximum() {
    return quality < MAXIMUM_QUALITY;
  }

  private void increaseQuality() {
    quality = quality + 1;
  }

  private void decreaseSellIn() {
    sellIn = sellIn - 1;
  }
}
