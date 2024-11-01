package com.gildedrose;

public class AgedBrie extends Item {

  public AgedBrie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  void updateQuality() {
    if (isQualityBellowTheMinimum()) {
      increaseQuality();
    }
  }

  @Override
  void updateQualityIfFinishSellIn() {
    if (isQualityBellowTheMinimum()) {
      increaseQuality();
    }
  }
}
