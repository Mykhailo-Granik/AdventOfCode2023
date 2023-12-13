package solutions.dec13;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorTest {

    @Test
    public void shouldCalculateScore() {
        var underTest = new ScoreCalculator(new RegularLandSymmetryCalculator());
        List<Land> lands = lands();
        assertEquals(405, underTest.calculateScore(lands));
    }

    @Test
    public void shouldCalculateScoreWithSmudges() {
        var underTest = new ScoreCalculator(new LandWithSmudgeSymmetryCalculator());
        List<Land> lands = lands();
        assertEquals(400, underTest.calculateScore(lands));
    }

    private List<Land> lands() {
        return List.of(
                new Land(
                        List.of(
                                "#.##..##.",
                                "..#.##.#.",
                                "##......#",
                                "##......#",
                                "..#.##.#.",
                                "..##..##.",
                                "#.#.##.#."
                        )
                ),
                new Land(
                        List.of(
                                "#...##..#",
                                "#....#..#",
                                "..##..###",
                                "#####.##.",
                                "#####.##.",
                                "..##..###",
                                "#....#..#"
                        )
                )
        );
    }

}