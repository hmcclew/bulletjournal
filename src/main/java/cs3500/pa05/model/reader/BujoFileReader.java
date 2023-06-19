package cs3500.pa05.model.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.controller.JavaJournalController;
import cs3500.pa05.model.Week;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class representing a .bujo file reader
 */
public class BujoFileReader implements FileReader {
  private Path path;
  private String fileContent;

  private JavaJournalController controller;

  /**
   * Constructor for a bujo file reader
   *
   * @param controller the main controller
   */
  public BujoFileReader(JavaJournalController controller) {
    this.controller = controller;
  }

  /**
   * reads the contents of the given file path
   *
   * @param filePath the string path to the file
   */
  @Override
  public void read(String filePath) {
    this.path = Paths.get(filePath);
    Week week;
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      this.fileContent = Files.readString(this.path);

      week = objectMapper.readValue(this.fileContent, Week.class);
      controller.setWeek(week);
    } catch (IOException e) {
      System.err.println("Could Not Read File");
    }
  }
}
