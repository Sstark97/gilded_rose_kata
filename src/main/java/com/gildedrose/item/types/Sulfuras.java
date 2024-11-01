package com.gildedrose.item.types;

import com.gildedrose.UpdatableItem;

public class Sulfuras extends Item implements UpdatableItem {

  public Sulfuras(String name, int sellIn) {
    super(name, sellIn, 80);
  }

  @Override
  public void update() {
    // Do nothing
  }
}
