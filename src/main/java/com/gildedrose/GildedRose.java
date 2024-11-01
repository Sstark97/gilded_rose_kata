package com.gildedrose;

import java.util.Arrays;
import java.util.List;

import com.gildedrose.item.types.Item;
import com.gildedrose.item.ItemFactory;

class GildedRose {

  List<UpdatableItem> items;

  public GildedRose(Item[] items) {
    this.items = Arrays.stream(items)
        .map(item -> ItemFactory.of(item.name, item.sellIn, item.quality))
        .toList();
  }

  public void updateQuality() {
    items.forEach(UpdatableItem::update);
  }
}