package solutions.dec17;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {

    @Test
    public void shouldFindTheShortestPath() {
        Grid grid = new Grid(
                firstGrid(),
                new RegularCrubiclesNodesGenerator(firstGrid().size(), firstGrid().get(0).length()),
                new RegularCrubiclesAllowedToStopPredicate()
        );
        assertEquals(102, grid.findShortestPath());
    }

    private List<String> firstGrid() {
        return List.of(
                "2413432311323",
                "3215453535623",
                "3255245654254",
                "3446585845452",
                "4546657867536",
                "1438598798454",
                "4457876987766",
                "3637877979653",
                "4654967986887",
                "4564679986453",
                "1224686865563",
                "2546548887735",
                "4322674655533"
        );
    }

    @Test
    public void shouldWorkForUltraCrubicle() {
        Grid grid = new Grid(
                firstGrid(),
                new UltraCrubiclesNextNodesGenerator(firstGrid().size(), firstGrid().get(0).length()),
                new UltraCrubiclesAllowedToStopPredicate()
        );
        assertEquals(94, grid.findShortestPath());
    }

    @Test
    public void shouldWorkForUltraCrubicleAndAnotherGrid() {
        Grid grid = new Grid(
                secondGrid(),
                new UltraCrubiclesNextNodesGenerator(secondGrid().size(), secondGrid().get(0).length()),
                new UltraCrubiclesAllowedToStopPredicate()
        );
        assertEquals(71, grid.findShortestPath());
    }

    private List<String> secondGrid() {
        return List.of(
                "111111111111",
                "999999999991",
                "999999999991",
                "999999999991",
                "999999999991"
        );
    }

}