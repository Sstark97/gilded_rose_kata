package com.gildedrose;

public class Item {

  private final String name;

  protected int sellIn;

  protected int quality;

  protected Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public static Item of(String name, int sellIn, int quality) {
    return switch (name) {
      case "Aged Brie" -> new AgedBrie(name, sellIn, quality);
      case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePasses(name, sellIn, quality);
      case "Sulfuras, Hand of Ragnaros" -> new Sulfuras(name, sellIn, quality);
      default -> new Item(name, sellIn, quality);
    };
  }

  void updateQuality() {
    if (notLoseAllQuality()) {
      decreaseQuality();
    }
  }

  void updateQualityIfFinishSellIn() {
    if (notLoseAllQuality()) {
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

  void decreaseSellIn() {
    sellIn = sellIn - 1;
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
