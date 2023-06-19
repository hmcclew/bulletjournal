package cs3500.pa05.model.reader;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.controller.JavaJournalController;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.reader.BujoFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

/**
 * Tests for the bujo file reader class
 */
public class BujoFileReaderTest {

  private BujoFileReader fileReader;
  private JavaJournalController mockController;

  @BeforeEach
  void setUp() {
    mockController = mock(JavaJournalController.class);
    fileReader = new BujoFileReader(mockController);
  }

  @Test
  void testRead() {
    Week week = new Week();
    week.setName("Week 1");

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonWeek = "";
    try {
      jsonWeek = objectMapper.writeValueAsString(week);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    Path tempFile = null;
    try {
      tempFile = Files.createTempFile(null, null);
      Files.write(tempFile, jsonWeek.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }


    fileReader.read(tempFile.toString());

    ArgumentCaptor<Week> argumentCaptor = ArgumentCaptor.forClass(Week.class);
    verify(mockController).setWeek(argumentCaptor.capture());

    Week capturedWeek = argumentCaptor.getValue();
    assertEquals("Week 1", capturedWeek.getName());


    try {
      Files.deleteIfExists(tempFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testException() {
    assertDoesNotThrow(() -> fileReader.read("invalid/path/to/file"));

    verify(mockController, never()).setWeek(any(Week.class));
  }
}

