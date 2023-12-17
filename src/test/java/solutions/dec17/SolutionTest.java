package solutions.dec17;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldCalculateTheShortestPath() {
        Solution solution = new Solution(
                new RegularCrubiclesNodesGenerator(grid().size(), grid().get(0).length()),
                new RegularCrubiclesAllowedToStopPredicate()
        );
        assertEquals(102, solution.calculateShortestPath(grid()));
    }

    private List<String> grid() {
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
    public void shouldCalculateTheShortestPathWithUltraCrubicles() {
        Solution solution = new Solution(
                new UltraCrubiclesNextNodesGenerator(grid().size(), grid().get(0).length()),
                new UltraCrubiclesAllowedToStopPredicate()
        );
        assertEquals(94, solution.calculateShortestPath(grid()));
    }

}