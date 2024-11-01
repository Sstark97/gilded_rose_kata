package com.gildedrose;

public class Conjured extends Item implements UpdatableItem {

  public Conjured(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    updateQuality();

    decreaseSellIn();

    updateQualityIfFinishSellIn();
  }

  private void updateQuality() {
    if (notLoseAllQuality()) {
      decreaseQuality();
    }
  }

  private void updateQualityIfFinishSellIn() {
    if (notLoseAllQuality() && isSellInFinish()) {
      decreaseQuality();
    }
  }

  private boolean isSellInFinish() {
    return sellIn < 0;
  }

  private boolean notLoseAllQuality() {
    return quality > 0;
  }

  private void decreaseSellIn() {
    sellIn = sellIn - 1;
  }

  private void decreaseQuality() {
    quality = quality - 2;
  }
}
