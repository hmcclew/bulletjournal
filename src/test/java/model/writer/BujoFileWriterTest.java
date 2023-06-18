package model.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import cs3500.pa05.model.writer.BujoFileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;


/**
 * Tests for the Bujo File writer class
 */
public class BujoFileWriterTest {

  @Test
  public void testWriteToFile() {
    BujoFileWriter writer = new BujoFileWriter();
    Path tempPath = Paths.get("test.bujo");
    String testContent = "Hello, World!";

    writer.writeToFile(tempPath, testContent);

    try {
      String content = new String(Files.readAllBytes(tempPath), StandardCharsets.UTF_8);
      assertEquals(testContent, content);
    } catch (IOException e) {
      fail("Failed to read the test file content.");
    } finally {

      try {
        Files.deleteIfExists(tempPath);
      } catch (IOException e) {
        fail("Failed to delete the test file.");
      }
    }
  }

  @Test
  public void testWriteToFileException() {
    BujoFileWriter writer = new BujoFileWriter();
    Path invalidPath = Paths.get("/invalid/path/test.bujo");
    String testContent = "Hello, World!";

    assertThrows(RuntimeException.class, () -> writer.writeToFile(invalidPath, testContent));
  }

}

