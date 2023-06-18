package model.reader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.controller.JavaJournalController;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.reader.BujoFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
        // Creating a sample week
        Week week = new Week();
        week.setName("Week 1");

        // Converting the week to JSON format
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonWeek = "";
        try {
            jsonWeek = objectMapper.writeValueAsString(week);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Writing the JSON to a temp file
        Path tempFile = null;
        try {
            tempFile = Files.createTempFile(null, null);
            Files.write(tempFile, jsonWeek.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading the temp file using BujoFileReader
        fileReader.read(tempFile.toString());

        // Verify the controller's openWeek method was called with the right parameter
        ArgumentCaptor<Week> argumentCaptor = ArgumentCaptor.forClass(Week.class);
        verify(mockController).openWeek(argumentCaptor.capture());

        Week capturedWeek = argumentCaptor.getValue();
        assertEquals("Week 1", capturedWeek.getName());

        // Delete the temp file
        try {
            Files.deleteIfExists(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testIOException() {
        // Try to read from an invalid file path
        assertDoesNotThrow(() -> fileReader.read("invalid/path/to/file"));

        // Verify the controller's openWeek method was never called
        verify(mockController, never()).openWeek(any(Week.class));
    }
}

