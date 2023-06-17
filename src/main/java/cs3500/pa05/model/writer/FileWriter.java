package cs3500.pa05.model.writer;

import java.nio.file.Path;
public interface FileWriter {
  void writeToFile(Path path, String contents);
}
