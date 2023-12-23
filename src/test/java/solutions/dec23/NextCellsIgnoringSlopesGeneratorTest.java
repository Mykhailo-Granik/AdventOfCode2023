package solutions.dec23;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NextCellsIgnoringSlopesGeneratorTest {

    @Test
    public void shouldGenerateNextCellsOnGridWithoutWallsOrSlopes() {
        List<String> grid = List.of(
                "...",
                "...",
                "..."
        );
        NextCellsIgnoringSlopesGenerator underTest = new NextCellsIgnoringSlopesGenerator(grid);
        assertEqualsIgnoringOrder(
                List.of(
                        new Cell(0, 1),
                        new Cell(1, 0),
                        new Cell(1, 2),
                        new Cell(2, 1)
                ),
                underTest.generateNextCells(new Cell(1, 1))
        );
    }

    private void assertEqualsIgnoringOrder(List<Cell> expected, List<Cell> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
    }

    @Test
    public void shouldNotIncludeCellsOutsideTheGrid() {
        List<String> grid = List.of(
                "...",
                "...",
                "..."
        );
        NextCellsIgnoringSlopesGenerator underTest = new NextCellsIgnoringSlopesGenerator(grid);
        assertEqualsIgnoringOrder(
                List.of(
                        new Cell(0, 1),
                        new Cell(1, 0)
                ),
                underTest.generateNextCells(new Cell(0, 0))
        );
    }

    @Test
    public void shouldNotIncludeForestCells() {
        List<String> grid = List.of(
                ".#.",
                "...",
                ".#."
        );
        NextCellsIgnoringSlopesGenerator underTest = new NextCellsIgnoringSlopesGenerator(grid);
        assertEqualsIgnoringOrder(
                List.of(
                        new Cell(1, 0),
                        new Cell(1, 2)
                ),
                underTest.generateNextCells(new Cell(1, 1))
        );
    }

    @Test
    public void downSlopesShouldBehaveAsEmptyCells() {
        List<String> grid = List.of(
                "...",
                ".v.",
                "..."
        );
        NextCellsIgnoringSlopesGenerator underTest = new NextCellsIgnoringSlopesGenerator(grid);
        assertEqualsIgnoringOrder(
                List.of(
                        new Cell(0, 1),
                        new Cell(1, 0),
                        new Cell(1, 2),
                        new Cell(2, 1)
                ),
                underTest.generateNextCells(new Cell(1, 1))
        );
    }

    @Test
    public void upSlopesShouldBehaveAsEmptyCells() {
        List<String> grid = List.of(
                "...",
                ".^.",
                "..."
        );
        NextCellsIgnoringSlopesGenerator underTest = new NextCellsIgnoringSlopesGenerator(grid);
        assertEqualsIgnoringOrder(
                List.of(
                        new Cell(0, 1),
                        new Cell(1, 0),
                        new Cell(1, 2),
                        new Cell(2, 1)
                ),
                underTest.generateNextCells(new Cell(1, 1))
        );
    }

    @Test
    public void leftSlopesShouldBehaveAsEmptyCells() {
        List<String> grid = List.of(
                "...",
                ".<.",
                "..."
        );
        NextCellsIgnoringSlopesGenerator underTest = new NextCellsIgnoringSlopesGenerator(grid);
        assertEqualsIgnoringOrder(
                List.of(
                        new Cell(0, 1),
                        new Cell(1, 0),
                        new Cell(1, 2),
                        new Cell(2, 1)
                ),
                underTest.generateNextCells(new Cell(1, 1))
        );
    }

    @Test
    public void rightSlopesShouldBehaveAsEmptyCells() {
        List<String> grid = List.of(
                "...",
                ".>.",
                "..."
        );
        NextCellsIgnoringSlopesGenerator underTest = new NextCellsIgnoringSlopesGenerator(grid);
        assertEqualsIgnoringOrder(
                List.of(
                        new Cell(0, 1),
                        new Cell(1, 0),
                        new Cell(1, 2),
                        new Cell(2, 1)
                ),
                underTest.generateNextCells(new Cell(1, 1))
        );
    }

}