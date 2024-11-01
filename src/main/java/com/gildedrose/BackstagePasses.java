package com.gildedrose;

public class BackstagePasses extends Item {

  public BackstagePasses(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  void updateQuality() {
    if (isQualityBellowTheMinimum() && isBackStage()) {
      increaseQualityOfBackStage();
    }
  }
}
