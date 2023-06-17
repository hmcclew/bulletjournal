package cs3500.pa05.model.writer;

import java.nio.file.Path;

/**
 * interface for a file writer
 */
public interface FileWriter {
  /**
   * writes the given contents to a given file path
   *
   * @param path the file path to be written to
   * @param contents the contents to be written
   */
  void writeToFile(Path path, String contents);
}
