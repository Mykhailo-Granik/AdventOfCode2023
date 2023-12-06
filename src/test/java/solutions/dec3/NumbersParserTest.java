package solutions.dec3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersParserTest {

    @Test
    public void shouldReturnEmptyListForEmptyGrid() {
        NumbersParser underTest = new NumbersParser();
        assertEquals(0, underTest.parse(List.of()).size());
    }

    @Test
    public void shouldParseSingleNumberInALine() {
        NumbersParser underTest = new NumbersParser();
        List<String> grid = List.of("123");
        assertEquals(List.of(new NumberInGrid(grid, 0, 0, 3)), underTest.parse(grid));
    }

    @Test
    public void shouldParseSingleNumberInALineWithSpaces() {
        NumbersParser underTest = new NumbersParser();
        List<String> grid = List.of("..123..");
        assertEquals(List.of(new NumberInGrid(grid, 0, 2, 5)), underTest.parse(grid));
    }

    @Test
    public void shouldParseSingleNumberInMultipleLines() {
        NumbersParser underTest = new NumbersParser();
        List<String> grid = List.of("..123..", ".456...");
        assertEquals(
                List.of(
                        new NumberInGrid(grid, 0, 2, 5),
                        new NumberInGrid(grid, 1, 1, 4)
                ),
                underTest.parse(grid)
        );
    }

    @Test
    public void shouldParseMultipleNumbersInSingleLine() {
        NumbersParser underTest = new NumbersParser();
        List<String> grid = List.of("..123..456...");
        assertEquals(
                List.of(
                        new NumberInGrid(grid, 0, 2, 5),
                        new NumberInGrid(grid, 0, 7, 10)
                ),
                underTest.parse(grid)
        );
    }

    @Test
    public void shouldParseMultipleNumbersInMultipleLines() {
        NumbersParser underTest = new NumbersParser();
        List<String> grid = List.of("..123..456...", "789...");
        assertEquals(
                List.of(
                        new NumberInGrid(grid, 0, 2, 5),
                        new NumberInGrid(grid, 0, 7, 10),
                        new NumberInGrid(grid, 1, 0, 3)
                ),
                underTest.parse(grid)
        );
    }

}