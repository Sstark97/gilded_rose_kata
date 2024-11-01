package com.gildedrose;

public class BackstagePasses extends Item implements UpdatableItem {

  public BackstagePasses(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    updateQuality();

    decreaseSellIn();

    updateQualityIfFinishSellIn();
  }

  public void updateQuality() {
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

  public void updateQualityIfFinishSellIn() {
    if (sellIn < 0) {
      quality = 0;
    }
  }

  private void increaseQuality() {
    quality = quality + 1;
  }

  private void decreaseSellIn() {
    sellIn = sellIn - 1;
  }

  private boolean isQualityBellowTheMinimum() {
    return quality < 50;
  }
}
