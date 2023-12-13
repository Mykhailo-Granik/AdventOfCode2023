package solutions.dec13;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void shouldCalculateSumOfScoresForEachLand() {
        var underTest = new Solution(new RegularLandSymmetryCalculator());
        assertEquals(405, underTest.sumOfScoresForEachLand(input()));
    }

    @Test
    public void shouldCalculateTheScoreForLandsWithSmudges() {
        var underTest = new Solution(new LandWithSmudgeSymmetryCalculator());
        assertEquals(400, underTest.sumOfScoresForEachLand(input()));
    }

    private List<String> input() {
        return List.of(
                "#.##..##.",
                "..#.##.#.",
                "##......#",
                "##......#",
                "..#.##.#.",
                "..##..##.",
                "#.#.##.#.",
                "",
                "#...##..#",
                "#....#..#",
                "..##..###",
                "#####.##.",
                "#####.##.",
                "..##..###",
                "#....#..#"
        );
    }

}