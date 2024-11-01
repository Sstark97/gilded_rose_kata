package com.gildedrose;

public class Item {

  private final String name;

  private int sellIn;

  private int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  void updateQualityIfFinishSellIn() {
    if (isAgedBrie() && isQualityBellowTheMinimum()) {
      increaseQuality();
    } else if (isBackStage()) {
      loseAllQuality();
    } else if (notLoseAllQuality() && isRegular()) {
      decreaseQuality();
    }
  }

  void updateQuality() {
    if (isQualityBellowTheMinimum() && isAgedBrie()) {
      increaseQuality();
    } else if (isQualityBellowTheMinimum() && isBackStage()) {
      increaseQualityOfBackStage();
    } else if (isRegular() && notLoseAllQuality()) {
      decreaseQuality();
    }
  }

  boolean notLoseAllQuality() {
    return quality > 0;
  }

  boolean isQualityBellowTheMinimum() {
    return quality < 50;
  }

  boolean finishSellIn() {
    return sellIn < 0;
  }

  void increaseQualityOfBackStage() {
    increaseQuality();
    if (sellIn < 11 && quality < 50) {
      increaseQuality();
    }

    if (sellIn < 6 && quality < 50) {
      increaseQuality();
    }
  }

  void loseAllQuality() {
    quality = 0;
  }

  boolean isRegular() {
    return !isSulfuras() && !isAgedBrie() && !isBackStage();
  }

  void decreaseSellIn() {
    sellIn = sellIn - 1;
  }

  boolean isAgedBrie() {
    return name.equals("Aged Brie");
  }

  boolean isBackStage() {
    return name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  boolean isSulfuras() {
    return name.equals("Sulfuras, Hand of Ragnaros");
  }

  void increaseQuality() {
    quality = quality + 1;
  }

  void decreaseQuality() {
    quality = quality - 1;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}
