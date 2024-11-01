package com.gildedrose;

public class AgedBrie extends Item implements UpdatableItem {

  public AgedBrie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    updateQuality();

    decreaseSellIn();

    updateQualityIfFinishSellIn();
  }

  private void updateQuality() {
    if (isQualityBellowTheMinimum()) {
      increaseQuality();
    }
  }

  private void updateQualityIfFinishSellIn() {
    if (isQualityBellowTheMinimum() && isSellInFinish()) {
      increaseQuality();
    }
  }

  private boolean isSellInFinish() {
    return sellIn < 0;
  }

  private boolean isQualityBellowTheMinimum() {
    return quality < 50;
  }

  private void increaseQuality() {
    quality = quality + 1;
  }

  private void decreaseSellIn() {
    sellIn = sellIn - 1;
  }
}
