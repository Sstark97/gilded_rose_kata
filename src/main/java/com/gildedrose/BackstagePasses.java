package com.gildedrose;

public class BackstagePasses extends Item {

  public BackstagePasses(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  void updateQuality() {
    if (isQualityBellowTheMinimum()) {
      increaseQuality();
      if (sellIn < 11 && quality < 50) {
        increaseQuality();
      }

      if (sellIn < 6 && quality < 50) {
        increaseQuality();
      }
    }
  }

  @Override
  void updateQualityIfFinishSellIn() {
    quality = 0;
  }
}
