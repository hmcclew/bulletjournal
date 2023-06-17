package cs3500.pa05.model.writer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class BujoFileWriter implements FileWriter {

  public void writeToFile(Path path, String contents) {

    byte[] data = contents.getBytes();

    try {
      Files.write(path, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
