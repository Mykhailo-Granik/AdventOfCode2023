package solutions.dec14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlatformScoreCalculatorTest {

    @Test
    public void shouldReturnZeroIfPlatformHasNoMovableRocks() {
        PlatformScoreCalculator platformScoreCalculator = new PlatformScoreCalculator();
        Platform platform = new Platform(
                List.of(
                        ".#",
                        ".#"
                )
        );
        assertEquals(0, platformScoreCalculator.calculateScore(platform));
    }

    @Test
    public void shouldCalculateTheScoreForPlatformWithOneRow() {
        PlatformScoreCalculator platformScoreCalculator = new PlatformScoreCalculator();
        Platform platform = new Platform(
                List.of(
                        "O#O"
                )
        );
        assertEquals(2, platformScoreCalculator.calculateScore(platform));
    }

    @Test
    public void shouldCalculateScoreForMultiLinePlatform() {
        Platform platform = new Platform(
                List.of(
                        "OOOO.#.O..",
                        "OO..#....#",
                        "OO..O##..O",
                        "O..#.OO...",
                        "........#.",
                        "..#....#.#",
                        "..O..#.O.O",
                        "..O.......",
                        "#....###..",
                        "#....#...."
                )
        );
        assertEquals(136, new PlatformScoreCalculator().calculateScore(platform));
    }

}