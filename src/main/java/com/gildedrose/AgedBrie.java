package com.gildedrose;

public class AgedBrie extends Item implements UpdatableItem {
  private static final int MAXIMUM_QUALITY = 50;

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
    if (isQualityBellowTheMaximum()) {
      increaseQuality();
    }
  }

  private void updateQualityIfFinishSellIn() {
    if (isQualityBellowTheMaximum() && isSellInFinish()) {
      increaseQuality();
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
