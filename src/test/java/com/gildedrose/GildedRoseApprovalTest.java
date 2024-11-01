package com.gildedrose;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(DiffReporter.class)
class GildedRoseApprovalTest {

  @Test
  void foo() {
    Item[] items = new Item[]{new Item("foo", 0, 0)};
    GildedRose app = new GildedRose(items);
    app.updateQualityOld();

    Approvals.verifyAll("Items", items);
  }

  @Test
  void thirtyDays() {
    ByteArrayOutputStream fakeoutput = new ByteArrayOutputStream();
    System.setOut(new PrintStream(fakeoutput));
    System.setIn(new ByteArrayInputStream("a\n".getBytes()));

    Program.main();
    String output = fakeoutput.toString();

    Approvals.verify(output);
  }
}
