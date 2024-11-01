package com.gildedrose;

public class Item {

  private final String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  void loseAllQuality() {
    quality = 0;
  }

  boolean isRegular() {
    return !isSulfuras() && !isAgedBrie();
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
