package solutions.dec10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CycleFinderTest {

    @Test
    public void shouldFindCycle() {
        Grid grid = new Grid(
                List.of(
                        ".....",
                        ".S-7.",
                        ".|.|.",
                        ".L-J.",
                        "....."
                )
        );
        List<Coordinate> cycle = new CycleFinder().findCycle(grid);
        assertEquals(
                List.of(
                        new Coordinate(2, 1),
                        new Coordinate(3, 1),
                        new Coordinate(3, 2),
                        new Coordinate(3, 3),
                        new Coordinate(2, 3),
                        new Coordinate(1, 3),
                        new Coordinate(1, 2),
                        new Coordinate(1, 1)
                ),
                cycle
        );
    }

}