package com.gildedrose;

public class AgedBrie extends Item implements UpdatableItem {

  public AgedBrie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    updateQuality();
    sellIn = sellIn - 1;
    if (sellIn < 0) {
      updateQualityIfFinishSellIn();
    }
  }

  public void updateQuality() {
    if (isQualityBellowTheMinimum()) {
      increaseQuality();
    }
  }

  public void updateQualityIfFinishSellIn() {
    if (isQualityBellowTheMinimum()) {
      increaseQuality();
    }
  }

  private void increaseQuality() {
    quality = quality + 1;
  }

  private boolean isQualityBellowTheMinimum() {
    return quality < 50;
  }
}
