package solutions.dec21;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfiniteGridCalculatorTest {

    @Test
    public void shouldCalculateForManyGrids() {
        List<String> grid = List.of(
                "#.#",
                ".S.",
                "#.#"
        );
        assertEquals(40, new InfiniteGridCalculator(grid, 7).count());
    }

    @Test
    public void shouldCalculateForManyGridsWithoutWalls() {
        List<String> grid = List.of(
                "#..",
                ".S.",
                "..."
        );
        assertEquals(58, new InfiniteGridCalculator(grid, 7).count());
    }

    @Test
    public void shouldCalculateForLargerGrids() {
        List<String> grid = List.of(
                ".......",
                ".......",
                ".......",
                "...S...",
                ".......",
                ".......",
                "......."
        );
        assertEquals(121, new InfiniteGridCalculator(grid, 10).count());
    }

}