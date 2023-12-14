package solutions.dec14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldCalculateTheScoreOfThePlatform() {
        Solution underTest = new Solution();
        List<String> platform = List.of(
                "O....#....",
                "O.OO#....#",
                ".....##...",
                "OO.#O....O",
                ".O.....O#.",
                "O.#..O.#.#",
                "..O..#O..O",
                ".......O..",
                "#....###..",
                "#OO..#...."
        );
        assertEquals(136, underTest.calculateScore(platform));
    }

}