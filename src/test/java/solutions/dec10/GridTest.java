package solutions.dec10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GridTest {

    @Test
    public void shouldFindACoordinateOfAStart() {
        Grid grid = new Grid(
                List.of(
                        "...",
                        "...",
                        ".S."
                )
        );
        assertEquals(new Coordinate(1, 2), grid.findStart());
    }

    @Test
    public void shouldThrowExceptionIfNoStartFound() {
        Grid grid = new Grid(
                List.of(
                        "...",
                        "...",
                        "..."
                )
        );
        assertThrows(IllegalArgumentException.class, grid::findStart);
    }

    @Test
    public void shouldReplaceCharacterAtCoordinate() {
        Grid grid = new Grid(
                List.of(
                        "...",
                        "...",
                        ".S."
                )
        );
        grid.replaceCharAt(new Coordinate(1, 2), 'L');
        assertEquals('L', grid.charAt(new Coordinate(1, 2)));
    }

    @Test
    public void shouldReturnMinusOneIfCycleNotPresent() {
        Grid grid = new Grid(
                List.of(
                        "---",
                        "---",
                        "---"
                )
        );
        assertEquals(-1, grid.cycleLengthOrMinusOne(new Coordinate(1, 2), Direction.RIGHT));
    }

    @Test
    public void shouldReturnCycleLengthIfItExists() {
        Grid grid = new Grid(
                List.of(
                        ".....",
                        ".F-7.",
                        ".|.|.",
                        ".L-J.",
                        "....."
                )
        );
        assertEquals(8, grid.cycleLengthOrMinusOne(new Coordinate(2, 1), Direction.RIGHT));
    }

    @Test
    public void shouldReturnEmptyListIfCycleNotPresent() {
        Grid grid = new Grid(
                List.of(
                        "---",
                        "---",
                        "---"
                )
        );
        assertEquals(List.of(), grid.cycleOrEmptyList(new Coordinate(1, 2), Direction.RIGHT));
    }

    @Test
    public void shouldReturnCycleIfItExists() {
        Grid grid = new Grid(
                List.of(
                        ".....",
                        ".F-7.",
                        ".|.|.",
                        ".L-J.",
                        "....."
                )
        );
        assertEquals(
                List.of(
                        new Coordinate(3, 1),
                        new Coordinate(3, 2),
                        new Coordinate(3, 3),
                        new Coordinate(2, 3),
                        new Coordinate(1, 3),
                        new Coordinate(1, 2),
                        new Coordinate(1, 1),
                        new Coordinate(2, 1)
                ),
                grid.cycleOrEmptyList(new Coordinate(2, 1), Direction.RIGHT));
    }


}