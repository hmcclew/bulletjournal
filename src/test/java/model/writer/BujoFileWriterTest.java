package model.writer;

import cs3500.pa05.model.writer.BujoFileWriter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class BujoFileWriterTest {

    @Test
    public void testWriteToFile() {
        BujoFileWriter writer = new BujoFileWriter();
        Path tempPath = Paths.get("test.bujo");
        String testContent = "Hello, World!";

        // Write content to the file
        writer.writeToFile(tempPath, testContent);

        // Read content from the file to verify it was written correctly
        try {
            String content = new String(Files.readAllBytes(tempPath), StandardCharsets.UTF_8);
            assertEquals(testContent, content);
        } catch (IOException e) {
            fail("Failed to read the test file content.");
        } finally {
            // Clean up by deleting the test file
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

        // Verify that the method throws an exception when provided with an invalid path
        assertThrows(RuntimeException.class, () -> writer.writeToFile(invalidPath, testContent));
    }

}

