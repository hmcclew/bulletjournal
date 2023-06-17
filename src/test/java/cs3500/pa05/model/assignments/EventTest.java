package cs3500.pa05.model.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

  @Test
  public void test() {
    Event e = new Event("name", "day", "start", "duration");
    assertEquals(e.getName(), "name");
  }
}