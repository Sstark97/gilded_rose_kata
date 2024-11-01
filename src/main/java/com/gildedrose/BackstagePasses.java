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

  private void updateQuality() {
    if (isQualityBellowTheMinimum()) {
      increaseQuality();
      increaseQualityIfElevenDaysOfSellInRemain();
      increaseQualityIfSixDaysOfSellInRemain();
    }
  }

  private void increaseQualityIfSixDaysOfSellInRemain() {
    if (isQualityBellowTheMinimum() && sellIn < 6) {
      increaseQuality();
    }
  }

  private void increaseQualityIfElevenDaysOfSellInRemain() {
    if (isQualityBellowTheMinimum() && sellIn < 11) {
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
