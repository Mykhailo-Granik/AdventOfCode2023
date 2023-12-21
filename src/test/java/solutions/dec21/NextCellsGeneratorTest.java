package solutions.dec21;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NextCellsGeneratorTest {

    @Test
    public void shouldGenerateNextLocationsInTheMiddleOfAnEmptyGrid() {
        List<String> grid = List.of(
                "...",
                "...",
                "..."
        );
        NextCellsGenerator underTest = new NextCellsGenerator(grid);
        Cell cell = new Cell(1, 1);
        assertEqualsIgnoringOrder(
                List.of(
                        new Cell(1, 0),
                        new Cell(1, 2),
                        new Cell(0, 1),
                        new Cell(2, 1)
                ),
                underTest.generate(cell)
        );
    }

    private void assertEqualsIgnoringOrder(List<Cell> expected, List<Cell> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
    }

    @Test
    public void shouldNotGoToCellsWithStones() {
        List<String> grid = List.of(
                ".#.",
                "#..",
                "..."
        );
        NextCellsGenerator underTest = new NextCellsGenerator(grid);
        Cell cell = new Cell(1, 1);
        assertEqualsIgnoringOrder(
                List.of(
                        new Cell(1, 2),
                        new Cell(2, 1)
                ),
                underTest.generate(cell)
        );
    }

    @Test
    public void shouldNotGoOutsideOfTheGrid() {
        List<String> grid = List.of(
                ".#.",
                "#..",
                "..."
        );
        NextCellsGenerator underTest = new NextCellsGenerator(grid);
        Cell cell = new Cell(0, 2);
        assertEqualsIgnoringOrder(
                List.of(
                        new Cell(1, 2)
                ),
                underTest.generate(cell)
        );
    }

}