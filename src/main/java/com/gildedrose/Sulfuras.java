package com.gildedrose;

public class Sulfuras extends Item implements UpdatableItem {

  public Sulfuras(String name, int sellIn) {
    super(name, sellIn, 80);
  }

  @Override
  public void update() {
    // Do nothing
  }
}
