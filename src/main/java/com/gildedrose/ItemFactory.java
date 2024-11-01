package com.gildedrose;

import static com.gildedrose.ItemTypes.*;

public class ItemFactory {

  private ItemFactory() {
    throw new IllegalStateException("Factory class");
  }

  public static UpdatableItem of(String name, int sellIn, int quality) {
    return switch (name) {
      case AGED_BRIE -> new AgedBrie(name, sellIn, quality);
      case BACKSTAGE -> new BackstagePasses(name, sellIn, quality);
      case CONJURED -> new Conjured(name, sellIn, quality);
      case SULFURAS -> new Sulfuras(name, sellIn);
      default -> new RegularItem(name, sellIn, quality);
    };
  }
}
