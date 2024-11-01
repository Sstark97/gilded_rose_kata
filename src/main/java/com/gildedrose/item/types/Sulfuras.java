package com.gildedrose.item.types;

import com.gildedrose.UpdatableItem;

public class Sulfuras extends Item implements UpdatableItem {

  public static final int INMUTABLE_QUALITY = 80;

  public Sulfuras(String name, int sellIn) {
    super(name, sellIn, INMUTABLE_QUALITY);
  }

  @Override
  public void update() {
    // Do nothing
  }
}
