package com.gildedrose;

public class Sulfuras extends Item {

  public Sulfuras(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  void updateQuality() {
    // Do nothing
  }

  @Override
  void updateQualityIfFinishSellIn() {
    // Do nothing
  }
}
