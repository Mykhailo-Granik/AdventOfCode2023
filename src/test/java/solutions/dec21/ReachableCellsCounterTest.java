package solutions.dec21;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReachableCellsCounterTest {

    @Test
    public void shouldTellOneCellIsReachableForZeroSteps() {
        List<String> grid = List.of("S");
        assertEquals(1, new ReachableCellsCounter(0, grid).count());
    }

    @Test
    public void shouldCountNumberOfReachableCellsForOneStep() {
        List<String> grid = List.of(
                ".#.",
                ".S.",
                "..."
        );
        assertEquals(3, new ReachableCellsCounter(1, grid).count());
    }

    @Test
    public void shouldCountNumberOfReachableCellsForLargerExample() {
        List<String> grid = List.of(
                "...........",
                ".....###.#.",
                ".###.##..#.",
                "..#.#...#..",
                "....#.#....",
                ".##..S####.",
                ".##..#...#.",
                ".......##..",
                ".##.#.####.",
                ".##..##.##.",
                "..........."
        );
        assertEquals(16, new ReachableCellsCounter(6, grid).count());
    }

}