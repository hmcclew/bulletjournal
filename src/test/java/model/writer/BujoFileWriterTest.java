package model.writer;

import cs3500.pa05.model.writer.BujoFileWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BujoFileWriterTest {

    @TempDir
    public Path tempDir;

    @Test
    public void testWriteToFile() throws Exception {
        String contents = "This is the content of the file.";
        Path path = Files.createTempFile(tempDir, "bujo", ".txt");

        BujoFileWriter writer = new BujoFileWriter();
        writer.writeToFile(path, contents);

        String actualContents = Files.readString(path);
        assertEquals(contents, actualContents);
    }
}

