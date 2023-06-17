package cs3500.pa05.model.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
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

  @Override
  public void read(String filePath) {
    this.path = Paths.get(filePath);
    Week week = new Week();
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      // Read the file content as a String
      this.fileContent = Files.readString(this.path);

      // Deserialize the JSON into a Week object
      week = objectMapper.readValue(this.fileContent, Week.class);
    } catch (IOException e) {
      e.printStackTrace(); // Handle or log the exception as needed
    }

    // Now you have the parsed Week object
    System.out.println(week);
  }


}
