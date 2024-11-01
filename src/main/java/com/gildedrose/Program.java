package com.gildedrose;

import static com.gildedrose.ItemTypes.*;

public class Program {

	public static void main(String... args) {
		System.out.println("OMGHAI!");

		Item[] items = new Item[] {
				new Item ("+5 Dexterity Vest", 10, 20),
				new Item (AGED_BRIE, 2, 0),
				new Item ("Elixir of the Mongoose", 5, 7),
				new Item (SULFURAS, 0, 80),
				new Item (SULFURAS, -1, 80),
				new Item (BACKSTAGE, 15, 20),
				new Item (BACKSTAGE, 10, 49),
				new Item (BACKSTAGE, 5, 49),
				new Item (CONJURED, 3, 6)
		};

		GildedRose app = new GildedRose(items);
		var appItems = app.items;

		for (int i = 0; i < 31; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
      for (UpdatableItem appItem : appItems) {
        System.out.println(appItem);
      }
			System.out.println();
			app.updateQuality();
		}
	}
}
