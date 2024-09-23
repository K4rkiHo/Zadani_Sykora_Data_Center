package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.mockito.Mockito.*;

class FileReaderTest {

    private FileReader fileReader;

    @BeforeEach
    void setUp() {
        fileReader = new FileReader();
    }

    @Test
    void testProcessRow_PrimeNumberInNumericCell() {
        Row mockRow = mock(Row.class);
        Cell mockCell = mock(Cell.class);
        when(mockRow.iterator()).thenReturn(List.of(mockCell).iterator());
        when(mockCell.getCellType()).thenReturn(CellType.NUMERIC);
        when(mockCell.getNumericCellValue()).thenReturn(7.0);
        String result = fileReader.processRow(mockRow);
        assertEquals("Načtena číselná hodnota: 7 je prvočíslo.", result);
    }

    @Test
    void testProcessRow_NonPrimeNumberInNumericCell() {
        Row mockRow = mock(Row.class);
        Cell mockCell = mock(Cell.class);
        when(mockRow.iterator()).thenReturn(List.of(mockCell).iterator());
        when(mockCell.getCellType()).thenReturn(CellType.NUMERIC);
        when(mockCell.getNumericCellValue()).thenReturn(4.0);
        String result = fileReader.processRow(mockRow);
        assertEquals("", result);
    }

    @Test
    void testProcessRow_PrimeNumberInStringCell() {
        Row mockRow = mock(Row.class);
        Cell mockCell = mock(Cell.class);
        when(mockRow.iterator()).thenReturn(List.of(mockCell).iterator());
        when(mockCell.getCellType()).thenReturn(CellType.STRING);
        when(mockCell.getStringCellValue()).thenReturn("  13   ");
        String result = fileReader.processRow(mockRow);
        assertEquals("Načten textová hodnota: 13 je prvočíslo.", result);
    }

    @Test
    void testProcessRow_NonPrimeNumberInStringCell() {
        Row mockRow = mock(Row.class);
        Cell mockCell = mock(Cell.class);
        when(mockRow.iterator()).thenReturn(List.of(mockCell).iterator());
        when(mockCell.getCellType()).thenReturn(CellType.STRING);
        when(mockCell.getStringCellValue()).thenReturn("  12   ");
        String result = fileReader.processRow(mockRow);
        assertEquals("", result);
    }
}