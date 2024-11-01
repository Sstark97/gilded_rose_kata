package com.gildedrose.item;

import com.gildedrose.UpdatableItem;
import com.gildedrose.item.types.AgedBrie;
import com.gildedrose.item.types.BackstagePasses;
import com.gildedrose.item.types.Conjured;
import com.gildedrose.item.types.RegularItem;
import com.gildedrose.item.types.Sulfuras;

import static com.gildedrose.item.ItemTypes.*;

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
