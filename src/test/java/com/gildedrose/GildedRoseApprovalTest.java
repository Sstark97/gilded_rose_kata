package com.gildedrose;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.gildedrose.item.types.Item;
import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(DiffReporter.class)
class GildedRoseApprovalTest {

  @Test
  void update_quality_of_regular_item_decrease_sell_in_once() {
    Item[] items = new Item[]{new Item("foo", 0, 0)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();

    Approvals.verifyAll("Items", app.items);
  }

  @Test
  void update_quality_in_one_month() {
    ByteArrayOutputStream fakeoutput = new ByteArrayOutputStream();
    System.setOut(new PrintStream(fakeoutput));
    System.setIn(new ByteArrayInputStream("a\n".getBytes()));

    Program.main();
    String output = fakeoutput.toString();

    Approvals.verify(output);
  }
}
