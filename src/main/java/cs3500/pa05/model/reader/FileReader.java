package cs3500.pa05.model.reader;

/**
 * interface for a file reader
 */
public interface FileReader {
  /**
   * reads the contents of the given file path
   *
   * @param path the string path to the file
   */
  void read(String path);
}
