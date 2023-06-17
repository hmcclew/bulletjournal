package cs3500.pa05.model.writer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * File writer for writing the week's content to a .bujo file
 */
public class BujoFileWriter implements FileWriter {

  /**
   * Writes the content to a .bujo file
   *
   * @param path the path to be written to
   * @param contents the contents to be written in the file
   */
  public void writeToFile(Path path, String contents) {

    byte[] data = contents.getBytes();

    try {
      Files.write(path, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
